package api.pg.pojo.landingpage;

public class Faq {
	
	private boolean enabled;
	private General general;
	private Student student;
	private Alumni alumni;
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public General getGeneral() {
		return general;
	}
	public void setGeneral(General general) {
		this.general = general;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Alumni getAlumni() {
		return alumni;
	}
	public void setAlumni(Alumni alumni) {
		this.alumni = alumni;
	}

}
