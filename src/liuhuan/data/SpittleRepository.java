package liuhuan.data;

import java.util.List;

import liuhuan.exception.SpittleNotFoundException;
import liuhuan.model.Spitter;
import liuhuan.model.Spittle;

public interface SpittleRepository {

	List<Spittle> findSpittles(long max,int count);
	
	Spittle findOne(long spittleId) throws SpittleNotFoundException;
}
