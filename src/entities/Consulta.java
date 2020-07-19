package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Consulta {
	
	public static void main(String[] args) {
			
			List<String> list = new ArrayList<>();
			
			list.add("Maria");
			list.add("Bob");
			list.add("Alex");
			list.add("Anna");
			list.add("Xanaina");
			list.add(2, "Marco");
			
			System.out.println(list.size());
			
			list.remove("Anna");
			
			for (String pessoa : list) {
				System.out.println(pessoa);
			}
			
			System.out.println("=======================================");
			
			list.removeIf(x -> x.charAt(0) == 'M');
			
			for (String pessoa : list) {
				System.out.println(pessoa);
			}
			
			System.out.println("=======================================");
			
			System.out.println("index of Bob: " + list.indexOf("Bob"));
			System.out.println("Index of Marco: " + list.indexOf("Marco"));
			
			System.out.println("=======================================");
			
			List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());
			
			for (String pessoa : result) {
				System.out.println(pessoa);
			}
			
			System.out.println("=======================================");
			
			String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
			
			System.out.println(name);
			
		
	}

}

