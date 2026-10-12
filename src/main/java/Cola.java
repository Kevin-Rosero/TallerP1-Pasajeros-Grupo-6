import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Cola {
    private final Queue<Pasajero> coleccion;

    public Cola() {
        coleccion = new LinkedList<>();
    }

    public void agregar(Pasajero p) {
        //R1: validar que el pasajero no sea nulo, que su nombre no sea nulo ni vacío, que el asiento esté entre 1 y 30, y que el asiento no esté ocupado en la cola.

        if (p == null) {
            throw new IllegalArgumentException("El pasajero no puede ser nulo");
        }

        if (p.getNombre() == null || p.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del pasajero no puede ser nulo ni estar vacío");
        }
        if (p.getNumeroAsiento() < 1 || p.getNumeroAsiento() > 30) {
            throw new IllegalArgumentException("El asiento debe estar entre 1 y 30");
        }
        for (Pasajero pasajero : coleccion) {
            if (pasajero.getNumeroAsiento() == p.getNumeroAsiento()) {
                throw new IllegalArgumentException("El asiento ya está ocupado en la cola");
            }
        }

        coleccion.offer(p);
    }

    public Pasajero extraer() {
        if (coleccion.isEmpty()) {
            throw new NoSuchElementException("Cola sin elementos");
        }
        return coleccion.poll();
    }

    public Pasajero frente() {
        if (coleccion.isEmpty()) {
            throw new NoSuchElementException("Cola sin elementos");
        }
        return coleccion.peek();
    }

    public int size() {
        return coleccion.size();
    }

    public boolean estaVacia() {
        return coleccion.isEmpty();
    }

    public List<Pasajero> obtenerPendientes() {
        return Collections.unmodifiableList(new ArrayList<>(coleccion));
    }

    public Pasajero buscarPorAsiento(int asiento) {
        if (asiento < 1 || asiento > 30) {
            throw new IllegalArgumentException(
                    "El asiento debe estar entre 1 y 30");
        }

        for (Pasajero pasajero : coleccion) {
            if (pasajero.getNumeroAsiento() == asiento) {
                return pasajero;
            }
        }

        return null;
    }

    public int posicionPorAsiento(int asiento) {
        if (asiento < 1 || asiento > 30) {
            throw new IllegalArgumentException(
                    "El asiento debe estar entre 1 y 30");
        }

        int posicion = 1;
        for (Pasajero pasajero : coleccion) {
            if (pasajero.getNumeroAsiento() == asiento) {
                return posicion;
            }
            posicion++;
        }

        return -1;
    }

    public Pasajero cancelarPorAsiento(int asiento) {
        // TODO R3: retirar únicamente al indicado y conservar el orden restante.
        throw new UnsupportedOperationException("Pendiente implementar R3: cancelación");
    }

    @Override
    public String toString() {
        if (coleccion.isEmpty()) {
            return "Cola sin elementos";
        }
        StringBuilder sb = new StringBuilder();
        int posicion = 1;
        for (Pasajero p : coleccion) {
            sb.append(posicion++).append(". ").append(p).append("\n");
        }
        return sb.toString();
    }
}
