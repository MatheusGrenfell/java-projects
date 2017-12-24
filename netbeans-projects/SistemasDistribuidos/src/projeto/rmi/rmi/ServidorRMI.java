package projeto.rmi.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import netbula.ORPC.rpc_err;
import projeto.rmi.bradesco.SistemaBancarioBradesco;
import projeto.rpc.SistemaBancarioRPC_cln;

//O n�mero da conta deste banco tem final 32 e do banco bradesco tem final 36
public class ServidorRMI extends UnicastRemoteObject implements RMIInterface {

    private SistemaBancarioBradesco servidorBradesco;
    private SistemaBancarioRPC_cln servRPC;

    public ServidorRMI(String ipServidoRPC, String ipServidorBradesco) throws RemoteException {
        super();
        try {
            servRPC = new SistemaBancarioRPC_cln(ipServidoRPC, "tcp");
            System.out.println("Servidor RPC conectado");
        } catch (rpc_err ex) {
            System.out.println("Servidor RPC indispon�vel, tente mais tarde");
        }
        try {
            servidorBradesco = (SistemaBancarioBradesco) Naming.lookup("//" + ipServidorBradesco + "/SistemaBancarioBradesco");
            System.out.println("Servidor Bradesco conectado");
        } catch (Exception ex) {
            System.out.println("Servidor Bradesco indispon�vel, tente mais tarde");
        }
    }

    @Override
    public boolean saque(long nrConta, String senha, double valor) throws RemoteException {
        try {
            String str = servRPC.getCliente(Long.toString(nrConta));
            if ("".equals(str)) {
                throw new RemoteException("Esta conta n�o existe");
            } else if (str.startsWith("Erro")) {
                throw new RemoteException(str);
            }
            String[] cliente = str.split(";");
            if (senha.equalsIgnoreCase(cliente[9])) {
                double saldo = Double.parseDouble(cliente[14]);
                if (valor < 1) {
                    throw new RemoteException("Valor m�nimo requerido para o saque � de R$ 1,00");
                }
                if (saldo < valor) {
                    throw new RemoteException("Saldo insuficiente para realizar esta opera��o");
                }
                String infoConta = cliente[0] + ";";
                infoConta += valor + ";";
                infoConta += "Saque;";
                String s = servRPC.addHistoricoMovimentacao(infoConta);
                if (!"".equals(s)) {
                    throw new RemoteException(s);
                }
                return true;
            }
            throw new RemoteException("Senha inv�lida");
        } catch (Exception ex) {
            throw new RemoteException(ex.getMessage());
        }
    }

    @Override
    public boolean deposito(long nrConta, double valor) throws RemoteException {
        try {
            String str = servRPC.getCliente(Long.toString(nrConta));
            if ("".equals(str)) {
                throw new RemoteException("Esta conta n�o existe");
            } else if (str.startsWith("Erro")) {
                throw new RemoteException(str);
            }
            if (valor < 1) {
                throw new RemoteException("Valor m�nimo requerido para o dep�sito � de R$ 1,00");
            }
            String[] cliente = str.split(";");
            String infoConta = cliente[0] + ";";
            infoConta += valor + ";";
            infoConta += "Dep�sito;";
            String s = servRPC.addHistoricoMovimentacao(infoConta);
            if (!"".equals(s)) {
                throw new RemoteException(s);
            }
            return true;
        } catch (Exception ex) {
            throw new RemoteException(ex.getMessage());
        }
    }

    @Override
    public boolean transferencia(long nrContaOrigem, String senha, double valor, long nrContaDestino) throws RemoteException {
        try {
            if (nrContaOrigem == nrContaDestino) {
                throw new RemoteException("O n�mero da conta de origem n�o pode ser igual a do destino");
            }
            String str = servRPC.getCliente(Long.toString(nrContaOrigem));
            if ("".equals(str)) {
                throw new RemoteException("Esta conta n�o existe");
            } else if (str.startsWith("Erro")) {
                throw new RemoteException(str);
            }
            String[] cliente = str.split(";");
            double saldo;
            if (senha.equalsIgnoreCase(cliente[9])) {
                saldo = Double.parseDouble(cliente[14]);
                if (saldo < valor) {
                    throw new RemoteException("Saldo insuficiente para realizar esta opera��o");
                }
                if (valor < 1) {
                    throw new RemoteException("Valor m�nimo requerido para a transfer�ncia � de R$ 1,00");
                }
            } else {
                throw new RemoteException("Senha inv�lida");
            }
            boolean depositou = false;
            if (Long.toString(nrContaDestino).endsWith("32")) {
                depositou = deposito(nrContaDestino, valor);
            } else if (Long.toString(nrContaDestino).endsWith("36")) {
                depositou = servidorBradesco.deposito(nrContaDestino, valor);
            } else {
                throw new RemoteException("A conta a ser transferido o valor � inexistente");
            }
            if (depositou) {
                String infoConta = cliente[0] + ";";
                infoConta += valor + ";";
                infoConta += "Saque;";
                String s = servRPC.addHistoricoMovimentacao(infoConta);
                if (!"".equals(s)) {
                    throw new RemoteException(s);
                }
                return true;
            }
            return false;
        } catch (Exception ex) {
            throw new RemoteException(ex.getMessage());
        }
    }
}