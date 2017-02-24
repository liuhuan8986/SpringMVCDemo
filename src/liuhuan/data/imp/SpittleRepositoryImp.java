package liuhuan.data.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import liuhuan.data.SpittleRepository;
import liuhuan.model.Spitter;
import liuhuan.model.Spittle;
@Component
public class SpittleRepositoryImp implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		// TODO Auto-generated method stub
		List<Spittle> list = new ArrayList<>();
		Spittle slider1 = new Spittle("消息0",new Date());
		Spittle slider2 = new Spittle("消息1",new Date());
		Spittle slider3 = new Spittle("消息2",new Date());
		Spittle slider4 = new Spittle("消息3",new Date());
		list.add(slider1);
		list.add(slider2);
		list.add(slider3);
		list.add(slider4);
		return list;
	}

	@Override
	public Spittle findOne(long spittleId) {
		// TODO Auto-generated method stub
		Spittle spittle = new Spittle(spittleId,"这是一段文字，不管你信不信，反正我是信了",new Date(),0.456,5.78);
		return spittle;
	}

}
