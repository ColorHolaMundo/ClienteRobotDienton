package com.colorholamundo.clienterobotdienton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.JPanel;

import com.colorholamundo.clienterobotdienton.util.TeoremaPitagoras;
import com.colorholamundo.comun.datosred.Coordenada;

/**
 *
 * @author COLOR HOLAMUNDO
 */
public class Mapa2D extends JPanel {

	private static final long serialVersionUID = -7460714633453061430L;

	private ArrayBlockingQueue<Coordenada> obstaculos = new ArrayBlockingQueue<Coordenada>(10000000);
	private ArrayBlockingQueue<Coordenada> tarea = new ArrayBlockingQueue<Coordenada>(100);

	private int radioPunto = 4;
	private int radioTarea = 14;
	private int pixelesPorCentimetro = 10;
	private int cmTriangulo = 4;

	private Color colorCarteciano = new Color(100, 149, 237);
	private Color colorTriangulo = new Color(61, 145, 64);
	private Color colorObstaculo = new Color(0, 0, 0);
	private Color colorTarea = new Color(153, 153, 0);
	private Color colorCamino = Color.red;

	public Mapa2D() {
		ingresarObstaculo(new Coordenada(-1, -1, 0, 0, 90));
	}

	public void reinicioMapa() {
		obstaculos.clear();
		tarea.clear();
		this.repaint();
		ingresarObstaculo(new Coordenada(-1, -1, 0, 0, 90));
	}

	public void ingresarObstaculo(Coordenada coordenada) {
		obstaculos.add(coordenada);
	}

	public void ingresarTarea(int x, int y) {
		tarea.add(new Coordenada(-1, -1, x, y, -1));
	}

	public void setPixelesPorCentimetro(int pixeles) {
		pixelesPorCentimetro = pixeles;
	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		super.paintComponent(grphcs);
		Coordenada coordenadaFinal = null;
		Coordenada coordenada = null;

		// Dibuja Plano Carteciano
		grphcs.setColor(colorCarteciano);
		dibujarPlanoCarteciano(grphcs);

		int altura = this.getHeight();
		int anchura = this.getWidth();

		Iterator<Coordenada> intera = obstaculos.iterator();

		while (intera.hasNext()) {

			coordenada = intera.next();
			coordenadaFinal = coordenada;

			// Dibuja obstaculo si es que existe
			if (coordenada.getX() != -1) {
				grphcs.setColor(colorObstaculo);
				dibujarPuntoObstaculo(grphcs, coordenada, anchura, altura);
			}

			// Dibuja el camino del Robot
			grphcs.setColor(colorCamino);
			dibujarPuntoRobot(grphcs, coordenada, anchura, altura);
		}

		if (coordenadaFinal != null) {
			// Dibuja el triangulo del robot
			grphcs.setColor(colorTriangulo);
			dibujarTriangulo(grphcs, coordenadaFinal, anchura, altura);
		}

		// Dibuja el triangulo tarea
		grphcs.setColor(colorTarea);
		intera = tarea.iterator();

		while (intera.hasNext()) {
			coordenada = intera.next();
			dibujarPuntoTarea(grphcs, coordenada, anchura, altura);
		}
	}

	private void dibujarTriangulo(Graphics grphcs, Coordenada coordenada, int anchura, int altura) {

		int[] puntosX = new int[3];
		int[] puntosY = new int[3];

		double angulo1 = coordenada.getAnguloRobot();
		double angulo2 = (angulo1 + 160) % 360;
		double angulo3 = (angulo2 + 40) % 360;

		puntosX[0] = (int) (coordenada.getRobotX() + TeoremaPitagoras.valorX(cmTriangulo, angulo1));
		puntosY[0] = (int) (coordenada.getRobotY() + TeoremaPitagoras.valorY(cmTriangulo, angulo1));

		puntosX[1] = (int) (coordenada.getRobotX() + TeoremaPitagoras.valorX(cmTriangulo, angulo2));
		puntosY[1] = (int) (coordenada.getRobotY() + TeoremaPitagoras.valorY(cmTriangulo, angulo2));

		puntosX[2] = (int) (coordenada.getRobotX() + TeoremaPitagoras.valorX(cmTriangulo, angulo3));
		puntosY[2] = (int) (coordenada.getRobotY() + TeoremaPitagoras.valorY(cmTriangulo, angulo3));

		for (int i = 0; i < puntosX.length; i++) {

			puntosX[i] = traslacionX(puntosX[i], anchura);
			puntosY[i] = traslacionY(puntosY[i], altura);
		}

		Polygon triangulo = new Polygon(puntosX, puntosY, 3);
		grphcs.fillPolygon(triangulo);

	}

	private void dibujarPlanoCarteciano(Graphics grphcs) {
		grphcs.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
		grphcs.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
	}

	private void dibujarPuntoObstaculo(Graphics g, Coordenada coordenada, int anchura, int altura) {
		g.fillOval(traslacionX(coordenada.getX(), anchura), traslacionY(coordenada.getY(), altura), radioPunto,
				radioPunto);
	}

	private void dibujarPuntoTarea(Graphics g, Coordenada coordenada, int anchura, int altura) {
		g.fillOval(traslacionX(coordenada.getRobotX(), anchura), traslacionY(coordenada.getRobotY(), altura),
				radioTarea, radioTarea);
	}

	private void dibujarPuntoRobot(Graphics g, Coordenada coordenada, int anchura, int altura) {
		g.fillOval(traslacionX(coordenada.getRobotX(), anchura), traslacionY(coordenada.getRobotY(), altura),
				radioPunto, radioPunto);
	}

	public int traslacionX(double obstaculoX, double anchura) {
		int x = (int) Math.round((anchura / 2) + (obstaculoX * pixelesPorCentimetro));
		return x;
	}

	private int traslacionY(double obstaculoY, double altura) {
		int y = (int) Math.round((altura / 2) + (obstaculoY * (-1) * pixelesPorCentimetro));
		return y;
	}

	public float posicionXenCM(float valorX) {
		float x = ((valorX - (getWidth() / 2)) / pixelesPorCentimetro);
		return x;
	}

	public float posicionYenCM(float valorY) {
		float y = (((getHeight() / 2) - valorY) / pixelesPorCentimetro);
		return y;
	}

}
