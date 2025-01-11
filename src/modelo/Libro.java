
package modelo;

import java.util.Date;

/**
 *
 * @author caill
 */
public class Libro {
    
    private int idLibro;
    private String titulo;
    private String Autor;
    private String Genero;
    private String editorial;
    private Date fecha;
    private int NumeroPaginas;

    public Libro() {
    }

    public Libro(int idLibro, String titulo, String Autor, String Genero, String editorial, Date fecha, int NumeroPaginas) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.Autor = Autor;
        this.Genero = Genero;
        this.editorial = editorial;
        this.fecha = fecha;
        this.NumeroPaginas = NumeroPaginas;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumeroPaginas() {
        return NumeroPaginas;
    }

    public void setNumeroPaginas(int NumeroPaginas) {
        this.NumeroPaginas = NumeroPaginas;
    }

    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", titulo=" + titulo + ", Autor=" + Autor + ", Genero=" + Genero + ", editorial=" + editorial + ", fecha=" + fecha + ", NumeroPaginas=" + NumeroPaginas + '}';
    }

    
    
    
    
    
}
