package myTest;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import myAdapter.MapAdapter;

/**
 * <b>TEST SUITE MAP ADAPTER TEST</b>
 * <br>
 * <br>
 * <b>Summary</b>
 * <br>
 * In questa classe di test andiamo a testare tutti i metodi presenti in MapAdapter con un test
 * dedicato ad ogni singolo metodo.
 * <br>
 * L'obiettivo risulta quello di assicurarsi che all'inserimento di vari entry nel MapAdapter ogni singolo metodo funzioni correttamente.
 * <br>
 * I test sono stati creati con la tecnologia Test Driven Development pertanto sono stati ideati prima del corrispettivo metodo di MapAdapter.
 * <br>
 * <br>
 *
 * <b>Test Suite Design</b>
 * <br>
 * Nella classe di testing abbiamo un test per ogni metodo implementato in MapAdapter.
 * Dei due MapAdapter inizializzati, uno sarà vuoto e l'altro conterrà 5 entry.
 * Sono usate stringhe e valori semplici come chiavi e valori delle entry.
 * mapAdapterF è usata come mappa di confronto.
 * <br>
 *
 * <b>Pre-Conditions</b>
 * <br>
 * Nel @Before vengono assegnate due mappe, la prima (mapAdapter) vuota e la seconda (mapAdapterF) viene popolata con 5 entry.
 * <br>
 *
 * <b>Post-Conditions</b>
 * <br>
 * Dopo ogni test mapAdapter torna vuota in vista di una nuova inizializzazione.
 * <br>
 *
 * <b>Test-cases</b>
 * <br>
 * Sono testati tutti i metodi di MapAdapter (i metodi delle classi interne private sono testati su classi di test separate).
 * <br>
 *
 * <b>Test Suite Execution Records</b>
 * <br>
 * Tutti i 23 test vengono effettuati correttamente.
 * <br>
 *
 * <b>Execution Variables</b>
 * <br>
 * Viene utilzzate due variabili MapAdapter private su cui vengono eseguiti tutti i test.
 * <br>
 *
 * @author Bussolotto Raffaele - n° mat.: 1224718
 * <br>
 */
public class MapAdapterTest {
	
	private MapAdapter mapAdapter;
	private MapAdapter mapAdapterF;
	
	@Before
	public void init() {
		mapAdapter = new MapAdapter();
		mapAdapterF = new MapAdapter();
		for(int i = 0; i < 5; i++) {
			mapAdapterF.put("k" + i, "e" + i);
		}
	}

	/**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.size()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo size restituisca sempre il numero corrente di entry nella mappa.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo returni un intero relativo alla quantità di entry nella mappa specificata.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetti mapAdapter con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetti mapAdapter con 3 elementi.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.size() deve restituire il numero di entry nella mappa.
   */
	@Test
	public void sizeTest(){
		Assert.assertEquals(0, mapAdapter.size());
		mapAdapter.put("k1", "e1");
		Assert.assertEquals(1, mapAdapter.size());
		mapAdapter.put("k2", "e2");
		mapAdapter.put("k3", "e3");
		mapAdapter.put("k4", "e4");
		Assert.assertEquals(4, mapAdapter.size());
		mapAdapter.remove("k3");
		Assert.assertEquals(3, mapAdapter.size());
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.value()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo size restituisca un oggetto non vuoto.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo returni una collezione di valori non vuota.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetti mapAdapter con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetti mapAdapter con 1 elementi.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.value() deve restituire la collezione di valori di tutte le entry della mappa.
   */
	@Test
	public void valuesTest(){
		mapAdapter.put("k1", "e1");
		Object valuesCollection = mapAdapter.values();
		Assert.assertNotNull(valuesCollection);
	}

	/**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.isEmpty()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo isEmpty dell'EntrySet restituisca true se l'EntrySet non contiene alcuna entry.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo returni true se l'entrySet specificata non contiene neanche un'entry.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetti mapAdapter di tipo MapAdapter e corrispettiva entrySet inizializzati con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetti mapAdapter di tipo MapAdapter e corrispettiva entrySet contenenti 1 entry.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.isEmpty() deve restituire true se l'entrySet specificata non contiene neanche un'entry.
   */
	@Test
	public void isEmptyTest(){
		Assert.assertTrue(mapAdapter.isEmpty());
		mapAdapter.put("k1", "e1");
		Assert.assertFalse(mapAdapter.isEmpty());
	}

	/**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.containsKey(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo contains della mappa restituisca true se l'entry specificata è contenuta nell'EntrySet.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo returni true se l'entry specificata come parametro è contenuta nell'entrySet della mappa.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapter di tipo MapAdapter inizializzato con 0 elemento.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * La mappa mapAdapter e il set entrySet contengono 1 entry.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.containsKey(Object) deve restituire true se la entry passata coem parametro è contenuta nell'entrySet della mappa.
   */
	@Test
	public void containsKeyTest(){
		Assert.assertFalse(mapAdapter.containsKey("k1"));
		mapAdapter.put("k1", "e1");
		Assert.assertTrue(mapAdapter.containsKey("k1"));
	}

	/**	
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.containsKey(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo contains della mappa sollevi un'eccezione NullPointerException se il parametro è null.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che provando a cercare un oggetto non Entry, venga restituita una NullPointerException.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto entrySet di tipo HSet inizializzato su una mappa con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * L'oggetto entrySet rimane invariato.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.containsKey(Object) restituisce NullPointerException.
   */
	@Test(expected = NullPointerException.class)
	public void containsKeyNullTest(){
		mapAdapter.containsKey(null);
	}

	/**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.containsValue(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo contains della mappa restituisca true se l'entry specificata è contenuta nell'EntrySet.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo returni true se l'entry specificata come parametro è contenuta nell'entrySet della mappa.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapter di tipo MapAdapter inizializzato con 0 elemento.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * La mappa mapAdapter e il set entrySet contengono 1 entry.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.containsValue(Object) deve restituire true se la entry passata coem parametro è contenuta nell'entrySet della mappa.
   */
	@Test
	public void containsValueTest(){
		Assert.assertFalse(mapAdapter.containsValue("e1"));
		mapAdapter.put("k1", "e1");
		Assert.assertTrue(mapAdapter.containsValue("e1"));
	}

	/**	
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.containsValue(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo contains della mappa sollevi un'eccezione NullPointerException se il parametro è null.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che provando a cercare un oggetto non Entry, venga restituita una NullPointerException.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto entrySet di tipo HSet inizializzato su una mappa con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * L'oggetto entrySet rimane invariato.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.containsValue(Object) restituisce NullPointerException.
   */
	@Test(expected = NullPointerException.class)
	public void containsValueNullTest(){
		mapAdapter.containsValue(null);
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.get(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che se si fa il get di una mappa vuota venga restituito null altrimenti venga restituito il valore dell'entry con chiave specificata.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo returni il valore dell'entry cercata.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetti mapAdapter con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetti mapAdapter con 1 elementi.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.get(Object) deve restituire il valore di un'entry data la sua key.
   */
	@Test
	public void getTest(){
		Assert.assertNull(mapAdapter.get("k4"));
		mapAdapter.put("k1", "e1");
		Assert.assertNotNull(mapAdapter.get("k1"));
		Assert.assertEquals("e1", mapAdapter.get("k1"));
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.get(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che se si cerca il valore di una chiave nulla venga restituita una NullPointerException.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo returni NullPointerException.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetti mapAdapter con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetto mapAdapter invariato.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.get(Object) deve restituire NullPointerException se la chiave specificata è null.
   */
	@Test(expected = NullPointerException.class)
	public void getNullTest(){
		mapAdapter.get(null);
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.put(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che la dimensione della mappa sia corretta dopo degli inserimenti di alcune entry.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo inserisca entry nella mappa in maniera corretta.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapter con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetto mapAdapter con 4 elementi.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.put(Object) deve inserire entry (chiave-valore) nella mappa se sostituisce i valori se una entry con una data chiave è già presente.
   */
	@Test
	public void putTest(){
		Assert.assertEquals(0, mapAdapter.size());
		mapAdapter.put("k1", "e1");
		Assert.assertEquals(1, mapAdapter.size());
		mapAdapter.put("k2", "e2");
		mapAdapter.put("k3", "e3");
		mapAdapter.put("k4", "e4");
		Assert.assertEquals(4, mapAdapter.size());
		mapAdapter.put("k4", "e4");
		Assert.assertEquals(4, mapAdapter.size());
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.put(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che venga lanciata NullPointerException se si tenta di aggiungere alla mappa una entry con chiave e valore nulli.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo restitusica NullPointerException.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapter con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetto mapAdapter invariato.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.put(Object) deve restituire NullPointerException se si tenta di inserire una entry con chiave e valore nulli.
   */
	@Test(expected = NullPointerException.class)
	public void putNullTest(){
		mapAdapter.put(null, null);
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.put(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che venga lanciata NullPointerException se si tenta di aggiungere alla mappa una entry con valore nullo.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo restitusica NullPointerException.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapter con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetto mapAdapter invariato.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.put(Object) deve restituire NullPointerException se si tenta di inserire una entry con valore nullo.
   */
	@Test(expected = NullPointerException.class)
	public void putNullValueTest(){
		mapAdapter.put("k", null);
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.put(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che venga lanciata NullPointerException se si tenta di aggiungere alla mappa una entry con chiave nulla.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo restitusica NullPointerException.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapter con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetto mapAdapter invariato.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.put(Object) deve restituire NullPointerException se si tenta di inserire una entry con chiave nulla.
   */
	@Test(expected = NullPointerException.class)
	public void putNullKeyTest(){
		mapAdapter.put(null, "el");
	}

		/**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.remove(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo remove un'entry specifica dalla mappa.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo rimuova da mappa una entry specifica passata come parametro.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetti mapAdapter di tipo MapAdapter e corrispettiva entrySet inizializzati con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetti mapAdapter di tipo MapAdapter e corrispettiva entrySet contenenti 0 entry.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.remove(Object) deve rimuovere una specifica entry dalla mappa e corrispettivo entrySet.
   */
	@Test
	public void removeTest(){
		for(int i = 0; i < 5; i++) {
			mapAdapter.put("k" + i, "e" + i);
		}
		Assert.assertEquals(5, mapAdapter.size());
		for(int i = 0; i < 5; i++) {
			Assert.assertEquals("e" + i, mapAdapter.remove("k" + i));
		}
		Assert.assertEquals(0, mapAdapter.size());
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.remove(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo remove della mappa sollevi un'eccezione NullPointerException se il parametro è null.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che provando a rimuovere un oggetto non Entry, venga restituita una NullPointerException.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapter con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * L'oggetto mappa rimane invariato.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.remove(Object) restituisce NullPointerException.
   */
	@Test(expected = NullPointerException.class)
	public void removeNullTest(){
		mapAdapter.remove(null);
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.putAll(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo inserisce correttamente all'interno della mappa tutti gli elementi della collezione specificata.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che inserendo tutti gli elementi di una mappa all'interno di un'altra, le eentry siano effettivamente le stesse.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapter con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetto mapAdapter con 5 elementi.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.putAll(Object) restituisce NullPointerException.
   */
	@Test
	public void putAllTest(){
		mapAdapter.putAll(mapAdapterF);
		Assert.assertEquals(mapAdapterF.size(), mapAdapter.size());
		for (int i = 0; i < 5; i++) {
			Assert.assertEquals("e" + i, mapAdapter.get("k" + i));
		}
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.putAll(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo putAll della mappa sollevi un'eccezione NullPointerException se il parametro è null.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che provando a inserire una collezione nulla venga lanciato NullPointerException.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapter con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * L'oggetto mappa rimane invariato.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.putAll(Object) restituisce NullPointerException.
   */
	@Test(expected = NullPointerException.class)
	public void putAllNullTest(){
		mapAdapter.putAll(null);
	}

	/**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.clear()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo clear svuoti la mappa.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo svuoti la mappa.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapterF inizializzato con 5 elemento.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * La mappa mapAdapterF contengono 0 entry.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.clear() deve svuotare la mappa.
   */
	@Test
	public void clearTest(){
		Assert.assertNotEquals(0, mapAdapterF.size());
		mapAdapterF.clear();
		Assert.assertEquals(0, mapAdapterF.size());
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.keySet()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo restituisca effetivamente un set di chiavi non nulla.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che venga restituito un keySet non nullo.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapter inizializzato con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetto mapAdapter invariato.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.keySet() deve restituire un keySet delle entry della mappa.
   */
	@Test
	public void keySetTest(){
		Assert.assertNotNull(mapAdapter.keySet());
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.values()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo restituisca effetivamente una collezione di valori non nulla.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che venga restituito un valueSet non nullo.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapter inizializzato con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetto mapAdapter invariato.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.values() deve restituire una valueCollection delle entry della mappa.
   */
	@Test
	public void valuestTest(){
		Assert.assertNotNull(mapAdapter.values());
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.entrySet()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo restituisca effetivamente un set di entry non nulla.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che venga restituito un entrySet non nullo.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapter inizializzato con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetto mapAdapter invariato.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.entrySet() deve restituire un set di entry della mappa.
   */
	@Test
	public void entrySetTest(){
		Assert.assertNotNull(mapAdapter.entrySet());
	}

	/**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.equals()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo equals dell'EntrySet restituisca true se l'EntrySet specificato è uguale all'EntrySet corrente.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo restituisca true se entrambi le mappe sono uguali.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapter con 0 entry.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * L'oggetto mapAdapter con 4 entry.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.equals() restituisce true se le mappe sono equivalenti.
   */
	@Test
	public void equalsTest(){
		MapAdapter ma = new MapAdapter();
		Assert.assertTrue(mapAdapter.equals(ma));
		for(int i = 0; i < 5; i++) {
			ma.put("k" + i, "e" + i);
		}
		Assert.assertFalse(mapAdapter.equals(ma));
		mapAdapter.putAll(ma);
		Assert.assertTrue(mapAdapter.equals(ma));
		mapAdapter.remove("k1");
		Assert.assertFalse(mapAdapter.equals(ma));
	}

	/**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.hashCode()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo hashCode della mappa restituisca lo stesso valore per due mappe uguali e un valore diverso per mappe diversi.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare se il metodo restituisce true se la mappa corrisponde alla mappa specificato come parametro.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetti mapAdapter 0 entry.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
	 * L'oggetto mapAdapter con 4 entry.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.hashCode() deve restituire l'hashCode corrispondente alla mappa specificato.
   */
	@Test
	public void hashCodeTest(){
		MapAdapter ma = new MapAdapter();
		for(int i = 0; i < 5; i++) {
			ma.put("k" + i, "e" + i);
		}
		mapAdapter.putAll(ma);
		Assert.assertEquals(mapAdapter.hashCode(), ma.hashCode());
		mapAdapter.remove("k1");
		Assert.assertNotEquals(mapAdapter.hashCode(), ma.hashCode());
	}

}
