package fecha;

/**
 * En esta clase vamos a guardar toda información relevante a la fecha: día,
 * mes, anio, etc.
 * 
 * @author manuel.garfia
 */
public class Fecha {
	public static final int DIEZ = 10;
	private int dia; // d�a
	private int mes; // mes
	private int anio; // a�o

	/**
	 * Método vacío
	 */
	public Fecha() {

	}

	/**
	 * Este método almacena el día, mes y anio de la fecha
	 * 
	 * @param dia  Día de la fecha
	 * @param mes  Mes de la fecha
	 * @param anio Anio de la fecha
	 */
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	/**
	 * Este método comprueba si la fecha, es decir, día, mes y anio introducidos son
	 * los correctos. Teniendo en cuenta también si el anio es bisiesto o no.
	 * 
	 * @return Tres boolean que indican true si el día, mes o anio es correcto y
	 *         false si es incorrecto.
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto;
		boolean mesCorrecto;
		boolean anioCorrecto;
		anioCorrecto = anio > 0;
		mesCorrecto = mes >= 1 && mes <= 12;
		boolean diaMayor1 = dia >= 1;
		switch (mes) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && dia <= 29;
			} else {
				diaCorrecto = diaMayor1 && dia <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && dia <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && dia <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Este método indica si el anio seleccionado es bisiesto o no.
	 * 
	 * @return Un boolean que en el caso de ser bisiesto será true y en caso de que
	 *         no sea bisiesto será false.
	 */
	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	private boolean esBisiesto() {
		return anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0;
	}

	/**
	 * Este método avanza al día siguiente de la fecha indicada.
	 */
	// M�todo diaSiguiente
	public void nextDay() {
		dia++;
		if (!fechaCorrecta()) {
			dia = 1;
			mes++;
			if (!fechaCorrecta()) {
				mes = 1;
				anio++;
			}
		}
	}

	/**
	 * El método toString muestra una cadena completa de la información aportada, en
	 * este caso la fecha.
	 * 
	 * @return Un cadena con la información completa de la fecha.
	 */
	// M�todo toString
	public String toString() {
		String res;
		if (dia < DIEZ && mes < DIEZ) {
			res = "0" + dia + "-0" + mes + "-" + anio;
		} else if (dia < DIEZ && mes >= DIEZ) {
			res = "0" + dia + "-" + mes + "-" + anio;
		} else if (dia >= DIEZ && mes < DIEZ) {
			res = dia + "-0" + mes + "-" + anio;
		} else {
			res = dia + "-" + mes + "-" + anio;
		}
		return res;
	}

}
