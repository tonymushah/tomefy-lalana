package lalana.execptions;

import lalana.data.model.car.Voiture;
import lalana.data.model.road.Lalana;

public class VoitureFitException extends Exception {
	private Voiture voiture;
	private Lalana lalana;

	public Voiture getVoiture() {
		return voiture;
	}

	public Lalana getLalana() {
		return lalana;
	}

	protected VoitureFitException(Voiture voiture, Lalana lalana) {
		super(String.format("La voiture ne peut pas rouller sur cette route (%d > %d)", voiture.getLargeur(),
				lalana.getLargeurAUnSens()));
		this.voiture = voiture;
		this.lalana = lalana;
	}

	public static void verify(Voiture voiture, Lalana lalana) throws VoitureFitException {
		if (voiture.getLargeur() > lalana.getLargeurAUnSens()) {
			throw new VoitureFitException(voiture, lalana);
		}
	}

}
