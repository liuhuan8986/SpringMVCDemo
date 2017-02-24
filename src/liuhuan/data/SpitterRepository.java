package liuhuan.data;

import liuhuan.model.Spitter;

public interface SpitterRepository {

	void save(Spitter spitter);
	
	Spitter findSpitterByUserName(String username);
}
