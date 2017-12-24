package exemplo.rpc.hello;

//Generated by Netbula JRPCGEN V2.5.6.
//Netbula JavaRPC demo, expires after a fixed date!
import netbula.ORPC.*;

abstract public class hello_svcb extends Svc implements hello {

    public hello_svcb(int prog, int ver) {
        super(prog, ver);
    }

    public hello_svcb() {
        super(hello._def_pno, hello._def_vno);
    }

    abstract public String sendHello(String in_arg);

    public XDT proc_call(int proc, XDR inXDR) throws XDRError {
        switch (proc) {
            case 0:
                return new XDTvoid();

            case 1:
                String _out_arg1;
                try {
                    XDTString _in_arg = new XDTString();
                    _in_arg.xdr(inXDR);
                    _out_arg1 = this.sendHello(_in_arg.value);
                } catch (XDRError e) {
                    throw e;
                }
                return new XDTString(_out_arg1);

            default:
                return null;
        }
    }
}
