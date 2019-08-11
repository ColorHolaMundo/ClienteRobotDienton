
package com.colorholamundo.clienterobotdienton;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import com.colorholamundo.comun.datosred.Coordenada;
import com.colorholamundo.comun.datosred.Instruccion;

/**
 *
 * @author COLOR HOLAMUNDO
 */

public class ClienteRobot extends SwingWorker<String, String> {

	private Socket conexion;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private String ipServidor;
	private int puerto;
	private Marco marco;

	public ClienteRobot(Marco marco, String ipServidor, int puerto) {
		this.marco = marco;
		this.ipServidor = ipServidor;
		this.puerto = puerto;
	}

	private void conectarAlServidor() throws IOException {
		conexion = new Socket(ipServidor, puerto);
	}

	private void obtenerFlujos() throws IOException {
		salida = new ObjectOutputStream(conexion.getOutputStream());
		salida.flush();
		entrada = new ObjectInputStream(conexion.getInputStream());
	}

	private void procesarConexion() throws IOException {
		Object mensaje = null;
		while (true) {
			try {
				mensaje = entrada.readObject();
				if (mensaje instanceof Coordenada) {

					Coordenada coordenada = (Coordenada) mensaje;
					marco.ingresarObstaculo(coordenada);
				}
			} catch (ClassNotFoundException ex) {
				System.out.println("Paquete no identificado");
			}
		}
	}

	public void cerrarConexion() {
		try {
			if (conexion != null) {
				conexion.close();
			}
			if (salida != null) {
				salida.close();
			}
			if (entrada != null) {
				entrada.close();
			}
		} catch (IOException ex) {
			System.out.println("Error: cerrar conexion");
		}
	}

	public void enviarDatos(Instruccion instruccion) {
		try {
			salida.writeObject(instruccion);
			salida.flush();

		} catch (IOException ex) {
			System.out.println("Error: enviar instruccion");
		}
	}

	@Override
	protected String doInBackground() {
		try {
			conectarAlServidor();
			obtenerFlujos();

			marco.conexionRealizada();

			procesarConexion();
			cerrarConexion();
		} catch (IOException ex) {
			if (ex.getMessage().equals("Socket closed")) {
				JOptionPane.showMessageDialog(marco, "CONEXION FINALIZADA");
			} else {
				JOptionPane.showMessageDialog(marco, "ERROR  EN LA CONEXION");
			}
		} finally {
			cerrarConexion();
		}
		
		return null;
	}

	@Override
	protected void done() {
		marco.conexionFinalizada();
	}
}
