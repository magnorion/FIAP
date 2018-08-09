package br.com.fiap.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.WeakHashMap;

import br.com.fiap.classes.ComparaArrayList;
import br.com.fiap.classes.ComparaHash;
import br.com.fiap.classes.ComparaHashMap;
import br.com.fiap.classes.ComparaLinkedList;
import br.com.fiap.classes.ComparaStack;
import br.com.fiap.classes.ComparaWeakHashMap;
import br.com.fiap.classes.ComparadorDados;

public class ListaComparacaoExercicio {
	public static void main(String[] args) {
		int position = 500000;
		
		ComparaArrayList comparadorArrayList = new ComparaArrayList("ArrayList", new ArrayList<Integer>());
		ComparaLinkedList comparadorLinkedList = new ComparaLinkedList("LinkedList", new LinkedList<Integer>());
		ComparaHash comparadorHash = new ComparaHash("HashSet", new HashSet<Integer>());
		ComparaStack comparadorStack = new ComparaStack("StackSet", new Stack<Integer>());
		ComparaHashMap comparadorHashMap = new ComparaHashMap("HashMap", new HashMap<Integer, Integer>());
		ComparaWeakHashMap comparadorWeakHashMap = new ComparaWeakHashMap("WeakHashMap", new WeakHashMap<Integer, Integer>());
		
		System.out.println("Teste: ArrayList vs LinkedList");
		// Inserção
		comparadorArrayList.insert();
		comparadorLinkedList.insert();
		System.out.println("Na inserção: " + ComparadorDados.compara(comparadorArrayList, comparadorArrayList));
		
		// Busca
		comparadorArrayList.select(position);
		comparadorLinkedList.select(position);
		System.out.println("Na busca: " + ComparadorDados.compara(comparadorArrayList, comparadorArrayList));	
		System.out.println("----");
	
		
		System.out.println("Teste: Stack vs HashSet");	
		// Inserção
		comparadorStack.insert();
		comparadorHash.insert();
		System.out.println("Na inserção: " + ComparadorDados.compara(comparadorStack, comparadorHash));
		
		// Busca
		comparadorStack.select(position);
		comparadorHash.select(position);
		System.out.println("Na busca: " + ComparadorDados.compara(comparadorStack, comparadorHash));
		System.out.println("----");
		
		
		System.out.println("Teste: HashMap vs WeakHashMap");	
		// Inserção
		comparadorHashMap.insert();
		comparadorWeakHashMap.insert();
		System.out.println("Na inserção: " + ComparadorDados.compara(comparadorHashMap, comparadorWeakHashMap));
		
		// Busca
		comparadorHashMap.select(position);
		comparadorWeakHashMap.select(position);
		System.out.println("Na busca: " + ComparadorDados.compara(comparadorHashMap, comparadorWeakHashMap));
		System.out.println("----");
		
	}
}
