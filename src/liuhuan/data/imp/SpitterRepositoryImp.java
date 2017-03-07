package liuhuan.data.imp;

import org.springframework.stereotype.Component;

import liuhuan.data.SpitterRepository;
import liuhuan.model.Spitter;
@Component
public class SpitterRepositoryImp implements SpitterRepository{
	@Override
	public void save(Spitter spitter) {
		// TODO Auto-generated method stub
		System.out.println("保存成功："+spitter.getUsername());
	}

	@Override
	public Spitter findSpitterByUserName(String username) {
		// TODO Auto-generated method stub
		System.out.println("findSpitterByUserName...:"+username);
		Spitter spitter = new Spitter();
		spitter.setFirstName("liu");
		spitter.setLastName("huan");
		spitter.setPassword("123456");
		spitter.setUsername(username);
		return spitter;
	}
}
