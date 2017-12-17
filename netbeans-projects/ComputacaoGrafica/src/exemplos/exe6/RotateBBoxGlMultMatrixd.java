package exemplos.exe6;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class RotateBBoxGlMultMatrixd implements GLEventListener, KeyListener {

    private GL gl;
    private GLU glu;
    private GLAutoDrawable glDrawable;
    private Transform matrix = new Transform();
    private double angGlobal;
    private Point[] object = {new Point(10.0, 10.0, 0.0, 1.0),
        new Point(10.0, 20.0, 0.0, 1.0), new Point(20.0, 20.0, 0.0, 1.0),
        new Point(20.0, 10.0, 0.0, 1.0)};

    // "render" feito logo apos a inicializacao do contexto OpenGL.
    public void init(GLAutoDrawable drawable) {
        System.out.println(" --- init ---");
        glDrawable = drawable;
        gl = drawable.getGL();
        glu = new GLU();
        glDrawable.setGL(new DebugGL(gl));

        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

        angGlobal = 0.0;
    }

    // metodo definido na interface GLEventListener.
    // "render" feito pelo cliente OpenGL.
    public void display(GLAutoDrawable arg0) {
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();

        // configurar window
        glu.gluOrtho2D(-30.0f, 30.0f, -30.0f, 30.0f);

        displaySRU();
        drawObject();

        gl.glFlush();
    }

    public void displaySRU() {
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2f(-20.0f, 0.0f);
        gl.glVertex2f(20.0f, 0.0f);
        gl.glEnd();
        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2f(0.0f, -20.0f);
        gl.glVertex2f(0.0f, 20.0f);
        gl.glEnd();
    }

    public void drawObject() {
        gl.glColor3f(0.0f, 0.0f, 0.0f);

        gl.glPushMatrix();
        gl.glMultMatrixd(matrix.GetDate(), 0);
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2d(object[0].GetX(), object[0].GetY());
        gl.glVertex2d(object[1].GetX(), object[1].GetY());
        gl.glVertex2d(object[2].GetX(), object[2].GetY());
        gl.glVertex2d(object[3].GetX(), object[3].GetY());
        gl.glEnd();
        gl.glPopMatrix();
    }

    public void dumpMatriz() {
        System.out.println("______________________");
        System.out.println("|" + matrix.GetElement(0) + " | "
                + matrix.GetElement(1) + " | " + matrix.GetElement(2) + " | "
                + matrix.GetElement(3));
        System.out.println("|" + matrix.GetElement(4) + " | "
                + matrix.GetElement(5) + " | " + matrix.GetElement(6) + " | "
                + matrix.GetElement(7));
        System.out.println("|" + matrix.GetElement(8) + " | "
                + matrix.GetElement(9) + " | " + matrix.GetElement(10) + " | "
                + matrix.GetElement(11));
        System.out.println("|" + matrix.GetElement(12) + " | "
                + matrix.GetElement(13) + " | " + matrix.GetElement(14) + " | "
                + matrix.GetElement(15));
    }

    public void dumpPoint() {
        System.out.println("P0[" + object[0].GetX() + "," + object[0].GetY()
                + "," + object[0].GetZ() + "," + object[0].GetW() + "]");
        System.out.println("P1[" + object[1].GetX() + "," + object[1].GetY()
                + "," + object[1].GetZ() + "," + object[1].GetW() + "]");
        System.out.println("P2[" + object[2].GetX() + "," + object[2].GetY()
                + "," + object[2].GetZ() + "," + object[2].GetW() + "]");
        System.out.println("P3[" + object[3].GetX() + "," + object[3].GetY()
                + "," + object[3].GetZ() + "," + object[3].GetW() + "]");
    }

    public void keyPressed(KeyEvent e) {
        Point point = new Point();
        double Lx = 0, Ly = 0;
        Transform matrixTranslate = new Transform();
        Transform matrixTranslateInverse = new Transform();

        double Sx = 1.0, Sy = 1.0;
        Transform matrixScale = new Transform();

        Transform matrixRotate = new Transform();

        Transform matrixGlobal = new Transform();

        switch (e.getKeyCode()) {
            case KeyEvent.VK_P:
                dumpPoint();
                break;
            case KeyEvent.VK_M:
                dumpMatriz();
                break;

            case KeyEvent.VK_R:
                matrix.MakeIdentity();
                break;

            case KeyEvent.VK_RIGHT:
                Lx = 2.0;
                point.SetX(Lx);
                matrixTranslate.MakeTranslation(point);
                matrix = matrix.transformMatrix(matrixTranslate);
                break;
            case KeyEvent.VK_LEFT:
                Lx = -2.0;
                point.SetX(Lx);
                matrixTranslate.MakeTranslation(point);
                matrix = matrix.transformMatrix(matrixTranslate);
                break;
            case KeyEvent.VK_UP:
                Ly = 2.0;
                point.SetY(Ly);
                matrixTranslate.MakeTranslation(point);
                matrix = matrix.transformMatrix(matrixTranslate);
                break;
            case KeyEvent.VK_DOWN:
                Ly = -2.0;
                point.SetY(Ly);
                matrixTranslate.MakeTranslation(point);
                matrix = matrix.transformMatrix(matrixTranslate);
                break;

            case KeyEvent.VK_PAGE_UP:
                Sx = 2.0;
                Sy = 2.0;
                matrixScale.MakeScale(Sx, Sy, 1.0);
                matrix = matrix.transformMatrix(matrixScale);
                break;
            case KeyEvent.VK_PAGE_DOWN:
                Sx = 0.5;
                Sy = 0.5;
                matrixScale.MakeScale(Sx, Sy, 1.0);
                matrix = matrix.transformMatrix(matrixScale);
                break;

            case KeyEvent.VK_HOME:
                angGlobal += 10.0; // rota��o em 10 graus
                matrixRotate.MakeZRotation(Transform.RAS_DEG_TO_RAD * angGlobal);
                matrix = matrix.transformMatrix(matrixRotate);
                break;
            case KeyEvent.VK_END:
                angGlobal -= 10.0; // rota��o em 10 graus
                matrixRotate.MakeZRotation(Transform.RAS_DEG_TO_RAD * angGlobal);
                matrix = matrix.transformMatrix(matrixRotate);
                break;

            // System.out.println("Multiplicacao de matrizes para rotacao com um ponto fixo, no caso (15,15).");
            case KeyEvent.VK_1:
                Lx = -15.0;
                Ly = -15.0; // tranla��o para origem
                point.SetX(Lx);
                point.SetY(Ly);
                matrixTranslate.MakeTranslation(point);

                matrixRotate.MakeZRotation(Transform.RAS_DEG_TO_RAD * 10);

                Lx = 15.0;
                Ly = 15.0; // tranla��o inversa, voltando a posi��o original
                point.SetX(Lx);
                point.SetY(Ly);
                matrixTranslateInverse.MakeTranslation(point);

                matrixGlobal = matrixGlobal.transformMatrix(matrixTranslateInverse);
                matrixGlobal = matrixGlobal.transformMatrix(matrixRotate);
                matrixGlobal = matrixGlobal.transformMatrix(matrixTranslate);

                matrix = matrix.transformMatrix(matrixGlobal);

                break;

            // System.out.println("Multiplicacao de matrizes para escala com um ponto fixo, no caso (15,15).");
            case KeyEvent.VK_2:
                Lx = -15.0;
                Ly = -15.0; // tranla��o para origem
                point.SetX(Lx);
                point.SetY(Ly);
                matrixTranslate.MakeTranslation(point);

                Sx = 0.5;
                Sy = 0.5; // escala reduzindo pela metade
                matrixScale.MakeScale(Sx, Sy, 1.0);

                Lx = 15.0;
                Ly = 15.0; // tranla��o inversa, voltando a posi��o original
                point.SetX(Lx);
                point.SetY(Ly);
                matrixTranslateInverse.MakeTranslation(point);

                matrixGlobal = matrixGlobal.transformMatrix(matrixTranslateInverse);
                matrixGlobal = matrixGlobal.transformMatrix(matrixScale);
                matrixGlobal = matrixGlobal.transformMatrix(matrixTranslate);

                matrix = matrix.transformMatrix(matrixGlobal);

                break;

            // System.out.println("Multiplicacao de matrizes para escala com um ponto fixo, no caso (15,15).");
            case KeyEvent.VK_3:
                Lx = -15.0;
                Ly = -15.0; // tranla��o para origem
                point.SetX(Lx);
                point.SetY(Ly);
                matrixTranslate.MakeTranslation(point);

                Sx = 2.0;
                Sy = 2.0; // escala dobrando
                matrixScale.MakeScale(Sx, Sy, 1.0);

                Lx = 15.0;
                Ly = 15.0; // tranla��o inversa, voltando a posi��o original
                point.SetX(Lx);
                point.SetY(Ly);
                matrixTranslateInverse.MakeTranslation(point);

                matrixGlobal = matrixGlobal.transformMatrix(matrixTranslateInverse);
                matrixGlobal = matrixGlobal.transformMatrix(matrixScale);
                matrixGlobal = matrixGlobal.transformMatrix(matrixTranslate);

                matrix = matrix.transformMatrix(matrixGlobal);

                break;
        }

        // System.out.println(" --- keyPressed ---");
        glDrawable.display();
    }

    // metodo definido na interface GLEventListener.
    // "render" feito depois que a janela foi redimensionada.
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
            int arg4) {
        // System.out.println(" --- reshape ---");
    }

    // metodo definido na interface GLEventListener.
    // "render" feito quando o modo ou dispositivo de exibicao associado foi
    // alterado.
    public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
        // System.out.println(" --- displayChanged ---");
    }

    public void keyReleased(KeyEvent arg0) {
        // System.out.println(" --- keyReleased ---");
    }

    public void keyTyped(KeyEvent arg0) {
        // System.out.println(" --- keyTyped ---");
    }
}
