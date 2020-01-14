package teste;

import java.io.Serializable;

public interface Transporte extends Serializable {
	public TipoTransporte getTipo();
	public void setTipo(TipoTransporte tipo);
}