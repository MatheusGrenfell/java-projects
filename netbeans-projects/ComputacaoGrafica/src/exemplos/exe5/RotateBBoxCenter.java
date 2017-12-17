package exemplos.exe5;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class RotateBBoxCenter implements GLEventListener, KeyListener {

    private GL gl;
    private GLU glu;
    private GLAutoDrawable glDrawable;

    // "render" feito logo ap�s a inicializa��o do contexto OpenGL.
    public void init(GLAutoDrawable drawable) {
        System.out.println(" --- init ---");
        glDrawable = drawable;
        gl = drawable.getGL();
        glu = new GLU();
        glDrawable.setGL(new DebugGL(gl));

        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    // m�todo definido na interface GLEventListener.
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
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2f(10.0f, 10.0f);
        gl.glVertex2f(20.0f, 20.0f);
        gl.glEnd();

        gl.glPushMatrix();
        // Inverse Translate of BBox center point
        gl.glTranslatef(15.0f, 15.0f, 0.0f);
        // Rotate 90 degree clock
        gl.glRotatef(-45.0f, 0, 0, 1);
        // Translate at origen using BBox center
        gl.glTranslatef(-15.0f, -15.0f, 0.0f);

        gl.glColor3f(0.0f, 1.0f, 1.0f);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2f(10.0f, 10.0f);
        gl.glVertex2f(20.0f, 20.0f);
        gl.glEnd();
        gl.glPopMatrix();
    }

    public void keyPressed(KeyEvent e) {
        System.out.println(" --- keyPressed ---");
    }

    // m�todo definido na interface GLEventListener.
    // "render" feito depois que a janela foi redimensionada.
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        System.out.println(" --- reshape ---");
    }

    // m�todo definido na interface GLEventListener.
    // "render" feito quando o modo ou dispositivo de exibi��o associado foi alterado.
    public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
        System.out.println(" --- displayChanged ---");
    }

    public void keyReleased(KeyEvent arg0) {
        System.out.println(" --- keyReleased ---");
    }

    public void keyTyped(KeyEvent arg0) {
        System.out.println(" --- keyTyped ---");
    }
}
