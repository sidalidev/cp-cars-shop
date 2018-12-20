package interfaces;

import java.util.List;

import entities.MotoEntity;

public interface IMoto {
	public void addMoto(MotoEntity m);
	public List<MotoEntity> getMotos();
	
	public void deleteMoto(int id);
}
