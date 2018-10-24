package Cadastros;

public class GetDuracaoMinutos {

	private final Viagem viagem;
	private int duracaoMinutos;
	
	public GetDuracaoMinutos(Viagem viagem) {
		this.viagem = viagem;
	}
	
	int compute() {
		if (viagem.getMinutosTermino() > viagem.getMinutoInicio()) 
			duracaoMinutos = viagem.getMinutosTermino() - viagem.getMinutoInicio();
		else {
			duracaoMinutos = 60 - viagem.getMinutoInicio() + viagem.getMinutosTermino();
			if (duracaoMinutos == 60) //caso especial
				duracaoMinutos = 0;
		}
		return duracaoMinutos;
	}
	
}
