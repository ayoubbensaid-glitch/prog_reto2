package modelo;

public class Cliente {
	
	private String DNI;
	private String Cliente_Nom;
	private String Cliente_Apel;
	private String Cliente_Correo;
	private String Cliente_Pass_hash;
	
	public Cliente(String DNI, String Cliente_Nom, String Cliente_Apel, String Cliente_Correo,String Cliente_Pass_hash)
	{
		this.DNI = DNI;
		this.Cliente_Nom = Cliente_Nom;
		this.Cliente_Apel = Cliente_Apel;
		this.Cliente_Correo = Cliente_Correo;
		this.Cliente_Pass_hash = Cliente_Pass_hash;
	}

	public Cliente()
	{
		DNI = "";
		Cliente_Nom = "";
		Cliente_Apel = "";
		Cliente_Correo = "";
		Cliente_Pass_hash = "";
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dni) {
		DNI = dni;
	}

	public String getCliente_Nom() {
		return Cliente_Nom;
	}

	public void setCliente_Nom(String cliente_Nom) {
		Cliente_Nom = cliente_Nom;
	}

	public String getCliente_Apel() {
		return Cliente_Apel;
	}

	public void setCliente_Apel(String cliente_Apel) {
		Cliente_Apel = cliente_Apel;
	}

	public String getCliente_Correo() {
		return Cliente_Correo;
	}

	public void setCliente_Correo(String cliente_Correo) {
		Cliente_Correo = cliente_Correo;
	}

	public String getCliente_Pass_hash() {
		return Cliente_Pass_hash;
	}

	public void setCliente_Pass_hash(String cliente_Pass_hash) {
		Cliente_Pass_hash = cliente_Pass_hash;
	}

	@Override
	public String toString() {
		return "El DNI del cliente es: " + DNI + " " + "El nombre del cliente es: "+ Cliente_Nom + " " + "El apellido del cliente es: " 
				+ Cliente_Apel + " " + "El correo electronico del cliente es: " + Cliente_Correo + "" + Cliente_Pass_hash;
	}

	
	
}