package Cadastros;

public class GetDuracaoHoras {
	private final Viagem viagem;
	private int duracaoHoras;
	
	public GetDuracaoHoras(Viagem viagem){
		this.viagem = viagem;
	}
	
	public int compute() {
		if (viagem.getHoraTermino() == viagem.getHoraInicio())
			duracaoHoras = 0;
		if (viagem.getHoraTermino() > viagem.getHoraInicio()) //varias possibilidades... 
			if (viagem.getHoraTermino() == viagem.getHoraInicio() + 1) {  
				if (viagem.getMinutosTermino() < viagem.getMinutoInicio())  //nao chegou a uma hora
					duracaoHoras = 0;
				else //durou pelo menos uma hora
					duracaoHoras = 1;
			} else { //possivelmente ultrapassou duas horas
				if (viagem.getHoraTermino() - viagem.getHoraInicio() > 2) //
					duracaoHoras = viagem.getHoraTermino() - viagem.getHoraInicio();
				else if (viagem.getHoraTermino() - viagem.getHoraInicio() == 2 &&   //certamente menos de duas horas  
						viagem.getMinutosTermino() < viagem.getMinutoInicio())    //e mais de uma hora
					duracaoHoras = 1;
				else //duracao de duas horas, certamente
					duracaoHoras = 2;
					
			}
		if (viagem.getHoraTermino() < viagem.getHoraInicio()) 
			duracaoHoras = -1; //para casos em que a hora de termino nao foi registrada
		return duracaoHoras;
	}
}
