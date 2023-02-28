package logica.objects;

public class Premio {

	private String code;
	private String name;
	private String type;
	private String foto;
	
	public Premio(String code, String name, String type) {
		setCode(code);
		setName(name);
		setType(type);
		setFoto("/img/"+code+".png");
	}

	
	public String getFoto() {
		return foto;
	}


	private void setFoto(String foto) {
		this.foto = foto;
	}


	public String getCode() {
		return code;
	}


	private void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	private void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	private void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return name; 
	}
	
	
}
