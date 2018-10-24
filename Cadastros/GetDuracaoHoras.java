package Cadastros;

public class GetDuracaoHoras {
	private final Viagem viagem;
	private int duracaoHoras;
	
	public GetDuracaoHoras(Viagem viagem){
		this.viagem = viagem;
	}
	
	public void setZeroDuracaoHoras() {
		duracaoHoras = 0;
	}
	
	public void setUmDuracaoHoras() {
		duracaoHoras = 1;
	}
	
	public boolean minutosTerminioMenorQueInicio() {
		if (viagem.getMinutosTermino() < viagem.getMinutoInicio()) {
			return true;
		}else {
			return false;
		}
	}
	
	public int horaTerminioMenosInicio() {
		return viagem.getHoraTermino() - viagem.getHoraInicio();
	}
	

	public int compute() {
		if (viagem.getHoraTermino() == viagem.getHoraInicio())
			setZeroDuracaoHoras();
		if (viagem.getHoraTermino() > viagem.getHoraInicio()) //varias possibilidades... 
			if (viagem.getHoraTermino() == viagem.getHoraInicio() + 1) {  
				if (minutosTerminioMenorQueInicio())  //nao chegou a uma hora
					setZeroDuracaoHoras();
				else //durou pelo menos uma hora
					setUmDuracaoHoras();
			} else { //possivelmente ultrapassou duas horas
				if (horaTerminioMenosInicio() > 2) //
					duracaoHoras = horaTerminioMenosInicio();
				else if (horaTerminioMenosInicio() == 2 &&   //certamente menos de duas horas  
						minutosTerminioMenorQueInicio())    //e mais de uma hora
					setUmDuracaoHoras();
				else //duracao de duas horas, certamente
					duracaoHoras = 2;
					
			}
		if (viagem.getHoraTermino() < viagem.getHoraInicio()) 
			duracaoHoras = -1; //para casos em que a hora de termino nao foi registrada
		return duracaoHoras;
	}
}
