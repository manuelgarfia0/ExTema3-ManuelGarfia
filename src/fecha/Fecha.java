package fecha;

/**
 * En esta clase vamos a guardar toda información relevante a la fecha: día,
 * mes, anio, etc.
 * 
 * @author manuel.garfia
 */
public class Fecha {
	private int d; // d�a
	private int m; // mes
	private int a; // a�o

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
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	/**
	 * Este método comprueba si la fecha, es decir, día, mes y anio introducidos son
	 * los correctos. Teniendo en cuenta también si el anio es bisiesto o no.
	 * 
	 * @return Tres boolean que indican true si el día, mes o anio es correcto y
	 *         false si es incorrecto.
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
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
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	/**
	 * Este método avanza al día siguiente de la fecha indicada.
	 */
	// M�todo diaSiguiente
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
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
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
