package uy.com.demente.ideas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.github.javafaker.Faker;

public class DataCollection {

	private List<String> list;

	public DataCollection() {
		list = new ArrayList<>();

		Faker faker;
		for (int i = 0; i < 200; i++) {

			faker = new Faker();

			String name = faker.name().fullName();
			list.add(name);

			// String streetAddress = faker.address().streetAddress();
			// String firstName = faker.name().firstName();
			// String lastName = faker.name().lastName();
		}
	}

	public long count() {
		long count = list.stream().distinct().count();
		return count;
	}

	public boolean exist(String name) {
		boolean isExist = list.stream().anyMatch(element -> element.contains(name));
		return isExist;
	}

	public List<String> filter(String match) {
		return list.stream().filter(element -> element.contains(match)).collect(Collectors.toList());
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
