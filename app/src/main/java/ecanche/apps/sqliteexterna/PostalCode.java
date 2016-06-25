package ecanche.apps.sqliteexterna;

/**
 * Created by lalo
 * Date: 25/06/16
 * Project: SQLiteExterna
 */
public class PostalCode {
    private String asenta, tipoAsenta, codigo;
    private int photoID;

    public PostalCode(String asenta, String tipoAsenta, String codigo, int photoID) {
        this.asenta = asenta;
        this.tipoAsenta = tipoAsenta;
        this.codigo = codigo;
        this.photoID = photoID;
    }

    public String getAsenta() {
        return asenta;
    }

    public void setAsenta(String asenta) {
        this.asenta = asenta;
    }

    public String getTipoAsenta() {
        return tipoAsenta;
    }

    public void setTipoAsenta(String tipoAsenta) {
        this.tipoAsenta = tipoAsenta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    @Override
    public String toString() {
        return "PostalCode{" +
                "asenta='" + asenta + '\'' +
                ", tipoAsenta='" + tipoAsenta + '\'' +
                ", codigo='" + codigo + '\'' +
                ", photoID=" + photoID +
                '}';
    }
}
