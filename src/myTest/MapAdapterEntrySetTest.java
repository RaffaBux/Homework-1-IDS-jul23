package myTest;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import myAdapter.HSet;
import myAdapter.HIterator;
import myAdapter.MapAdapter;
import myAdapter.HCollection;
import myAdapter.MapAdapter.Entry;

/**
 * <b>TEST SUITE MAP ADAPTER ENTRY SET TEST</b>
 * <br>
 * <br>
 * <b>Summary</b>
 * <br>
 * In questa classe di test andiamo a testare tutti i metodi presenti in MapAdapter.EntrySet e MapAdapter.EntrySetIterator con un test dedicato ad ogni singolo metodo.
 * <br>
 * L'obiettivo risulta quello di assicurarsi che all'inserimento di vari entry nel MapAdapter, ci sia corrispondenza tra il MapAdapter
 * e il corrispettivo HSet.
 * <br>
 * I test sono stati creati con la tecnologia Test Driven Development pertanto sono stati ideati prima del corrispettivo metodo di MapAdapter.EntrySet.
 * <br>
 * <br>
 *
 * <b>Test Suite Design</b>
 * <br>
 * Nella classe di testing abbiamo un test per ogni metodo implementato in MapAdapter.EntrySet e MapAdapter.EntrySetIterator.
 * Dei tre MapAdapter inizializzati, uno sarà vuoto e gli altri conterranno una entry ciascuno.
 * Sono inoltre inizializzati gli HSet corrispondenti ai tre MapAdapter.
 * Sono usate stringhe e valori semplici come chiavi e valori delle entry.
 * entrySet, entrySetF e entrySetF2 sono usati come HSet di confronto.
 * <br>
 *
 * <b>Pre-Conditions</b>
 * <br>
 * Nel @Before vengono inizializzate le tre mappe, la prima (mapAdapter) vuota e la seconda e la terza (mapAdapterF, mapAdapterF2) viene popolata con 1 entry.
 * Vengono poi inizializzati i set corrispondenti alle mappe.
 * <br>
 *
 * <b>Post-Conditions</b>
 * <br>
 * Dopo ogni test mapAdapter torna vuoto mentre mapAdapterF e mapAdapterF2 vengono riassegnati e popolati con una entry.
 * <br>
 *
 * <b>Test-cases</b>
 * <br>
 * Sono testati tutti i metodi di MapAdapter.EntrySet e MapAdapter.EntrySetIterator.
 * <br>
 *
 * <b>Test Suite Execution Records</b>
 * <br>
 * Tutti i 24 test vengono effettuati correttamente.
 * <br>
 *
 * <b>Execution Variables</b>
 * <br>
 * Viene utilzzate tre variabili MapAdapter private e tre variabili HSet su cui vengono eseguiti tutti i test.
 * <br>
 *
 * @author Bussolotto Raffaele - n° mat.: 1224718
 * <br>
 */
public class MapAdapterEntrySetTest {
	
	private MapAdapter mapAdapter;
	private MapAdapter mapAdapterF;
	private MapAdapter mapAdapterF2;
	private HSet entrySet;
	private HSet entrySetF;
	private HSet entrySetF2;
	
	@Before
	public void init() {
		mapAdapter = new MapAdapter();
		entrySet = mapAdapter.entrySet();
		mapAdapterF = new MapAdapter();
		mapAdapterF.put("k", "e");
		entrySetF = mapAdapterF.entrySet();
		mapAdapterF2 = new MapAdapter();
		mapAdapterF2.put("k", "e");
		entrySetF2 = mapAdapterF2.entrySet();
	}

	/**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.EntrySet.add(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo add dell'EntrySet sollevi un'eccezione UnsupportedOperationException quando si cerca di aggiungere un'entry al set.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo ritorni errore quando si prova ad aggiungere una entry al set corrispondente ad una mappa esistente.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto entrySet di tipo HSet inizializzato su una mappa con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * L'oggetto entrySet rimane invariato
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.EntrySet.add(Object) deve ritornare UnsupportedOperationException.
   */
	@Test(expected = UnsupportedOperationException.class)
	public void addTest() {
		entrySet.add("k");
	}

	/**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.EntrySet.addAll(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo addAll dell'EntrySet sollevi un'eccezione UnsupportedOperationException quando si cerca di aggiungere una collezione di entry al set.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo ritorni errore quando si prova ad aggiungere una collezione di entry al set corrispondente ad una mappa esistente.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto entrySet di tipo HSet inizializzato su una mappa con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * L'oggetto entrySet rimane invariato
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.EntrySet.addAll(Object) deve ritornare UnsupportedOperationException.
   */
	@Test(expected = UnsupportedOperationException.class)
	public void addAllTest() {
		entrySet.addAll(null);
	}
	
   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.EntrySet.put()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che l'aggiunta di un'entry alla mappa corrispondente influenzi anche la dimensione dell'EntrySet.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che, aggiungendo una entry a un dato entrySet, venga aggiunta la stessa entry anche alla relativa mappa.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto entrySetF di tipo HSet inizializzato su una mappa con 1 elemento.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetto entrySetF di tipo HSet inizializzato su una mappa con 2 elementi.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.EntrySet.addParentTest() deve, aggiungendo una entry a un dato entrySet, aggiungere la stessa entry anche alla relativa mappa.
   */
	@Test
	public void addParentTest() {
		int prevSize = mapAdapterF.size();
		Assert.assertEquals(mapAdapterF.size(), entrySetF.size());
		mapAdapterF.put("kk", "ee");
		Assert.assertEquals(prevSize+1, mapAdapterF.size());
		Assert.assertEquals(mapAdapterF.size(), entrySetF.size());
	}
	
	/**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.KeySet.clear()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo clear dell'EntrySet svuoti la mappa corrispondente e aggiorni l'EntrySet.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo svuoti la mappa corrispodnente all'entrySet specificato e aggiorni l'entrySet.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapterF di tipo MapAdapter inizializzato con 1 elemento.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * La mappa e l'entrySet corrispodnente contengono 0 entry.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.KeySet.clear() deve svuotare la mappa corrispondente all'entrySet specificato.
   */
	@Test
	public void clearTest() {
		Assert.assertEquals(mapAdapterF.size(), entrySetF.size());
		entrySetF.clear();
		Assert.assertEquals(0, mapAdapterF.size());
		Assert.assertEquals(mapAdapterF.size(), entrySetF.size());
	}
	
	/**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.KeySet.contains(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo contains dell'EntrySet restituisca true se l'entry specificata è contenuta nell'EntrySet.
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
   * Il metodo myAdapter.MapAdapter.KeySet.contains(Object) deve restituire true se la entry passata coem parametro è contenuta nell'entrySet della mappa.
   */
	@Test
	public void containsTest() {
		mapAdapter.put("k", "e");
		Assert.assertTrue(entrySet.contains(new MapAdapter.Entry("k", "e")));
		Assert.assertFalse(entrySet.contains(new MapAdapter.Entry("k", "e1")));
		Assert.assertFalse(entrySet.contains(new MapAdapter.Entry("k1", "e")));
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.EntrySet.containsClassTest()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo contains dell'EntrySet sollevi un'eccezione ClassCastException se il parametro non è un'entry.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che provando a cercare un oggetto non Entry, venga restituita una ClassCastException.
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
   * Il metodo myAdapter.MapAdapter.EntrySet.containsClassTest() restituisce ClassCastException.
   */
	@Test(expected = ClassCastException.class)
	public void containsClassTest() {
		entrySet.contains("k");
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.EntrySet.containsNullTest()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo contains dell'EntrySet sollevi un'eccezione NullPointerException se il parametro è null.
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
   * Il metodo myAdapter.MapAdapter.EntrySet.containsNullTest() restituisce NullPointerException.
   */
	@Test(expected = NullPointerException.class)
	public void containsNullTest() {
		entrySet.contains(null);
	}
	
   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.KeySet.containsAll(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo containsAll dell'EntrySet restituisca true se tutte le entry dell'EntrySet specificato sono contenute nell'EntrySet corrente.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo returni true se l'entrySet passato come parametro è completamente contenuto nell'entrySet relativo alla mappa.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetti mapAdapterF e mapAdapterF2 di tipo MapAdapter inizializzati con 1 elemento.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetti mapAdapterF e mapAdapterF2 di tipo MapAdapter contenenti rispettivamente 2 e 6 entry.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.KeySet.containsAll(Object) deve restituire true se l'entrySet passato come parametro è completamente contenuto nell'entrySet relativo alla mappa.
   */
	@Test
	public void containsAllTest() {
		for(int i = 0; i < 5; i++) {
			mapAdapterF2.put("k" + i, "e" + i);
		}
		Assert.assertTrue(entrySetF2.containsAll(entrySetF));
		mapAdapterF.put("kk", "ee");
		Assert.assertFalse(entrySetF2.containsAll(entrySetF));
	}
	
   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.EntrySet.containsAllClassTest()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo containsAll dell'EntrySet sollevi un'eccezione ClassCastException se il parametro non è un'HCollection.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che provando a cercare un oggetto non Entry, venga restituita una ClassCastException.
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
   * Il metodo myAdapter.MapAdapter.EntrySet.containsAllClassTest() restituisce ClassCastException.
   */
	@Test(expected = ClassCastException.class)
	public void containsAllClassTest() {
		MapAdapter ma = new MapAdapter();
		ma.put(4, "el");
		entrySet.containsAll((HCollection) ma);
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.EntrySet.containsAllNullTest()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo containsAll dell'EntrySet sollevi un'eccezione NullPointerException se il parametro è null.
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
   * Il metodo myAdapter.MapAdapter.EntrySet.containsAllNullTest() restituisce NullPointerException.
   */
	@Test(expected = NullPointerException.class)
	public void containsAllNullTest() {
		entrySet.containsAll(null);
	}
	
   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.KeySet.isEmpty()
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
   * Il metodo myAdapter.MapAdapter.KeySet.isEmpty() deve restituire true se l'entrySet specificata non contiene neanche un'entry.
   */
	@Test
	public void isEmptyTest() {
		Assert.assertTrue(entrySet.isEmpty());
		mapAdapter.put("k", "e");
		Assert.assertFalse(entrySet.isEmpty());
	}
	
	/**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.KeySet.iterator()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo iterator dell'EntrySet restituisca un iteratore valido e che sia possibile rimuovere le entry.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo returni un oggetto di tipo EntrySetIterator che permette di iterare l'entrySet e operare sulle sue entry.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetti mapAdapterF di tipo MapAdapter e corrispettiva entrySetF inizializzati con 1 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetti mapAdapterF di tipo MapAdapter e corrispettiva entrySetF contenenti 0 entry.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.KeySet.iterator() deve restituire un oggetto di tipo EntrySetIterator che permette di iterare l'entrySet e operare sulle sue entry.
   */
	@Test
	public void iteratorTest() {
		HIterator it = entrySetF.iterator();
		Assert.assertNotNull(it);
		Assert.assertTrue(it.hasNext());
		Assert.assertNotNull(it.next());
		int prevSize = entrySetF.size();
		it.remove();
		Assert.assertEquals(prevSize - 1, entrySetF.size());
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.EntrySet.iteratorIllTest()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo remove dell'iteratore dell'EntrySet sollevi un'eccezione IllegalStateException se la rimozione viene chiamata prima di next.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che provando a rimuovere un oggetto Entry in posizione illegale, venga restituita una IllegalStateException.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto entrySetF di tipo HSet inizializzato su una mappa con 1 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * L'oggetto entrySetF rimane invariato.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.EntrySet.iteratorIllTest() restituisce IllegalStateException.
   */
	@Test(expected = IllegalStateException.class)
	public void iteratorIllTest(){
		HIterator it = entrySetF.iterator();
		it.remove();
	}
	
	/**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.KeySet.remove(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo remove dell'EntrySet rimuova correttamente un'entry specifica dalla mappa e dall'EntrySet.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo rimuova da entrySet e corrispondente mappa una entry specifica passata come parametro.
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
   * Il metodo myAdapter.MapAdapter.KeySet.remove(Object) deve rimuovere una specifica entry dalla mappa e corrispettivo entrySet.
   */
	@Test
	public void removeTest() {
		Assert.assertTrue(entrySet.isEmpty());
		mapAdapter.put("k", "e");
		Assert.assertFalse(entrySet.isEmpty());
		entrySet.remove(new MapAdapter.Entry("k", "e"));
		Assert.assertTrue(entrySet.isEmpty());
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.EntrySet.remove()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo remove dell'EntrySet sollevi un'eccezione ClassCastException se il parametro non è un'entry.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che provando a rimuovere un oggetto non Entry, venga restituita una ClassCastException.
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
   * Il metodo myAdapter.MapAdapter.EntrySet.remove() restituisce ClassCastException.
   */
	@Test(expected = ClassCastException.class)
	public void removeClassTest() {
		entrySet.remove("k");
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.EntrySet.remove()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo remove dell'EntrySet sollevi un'eccezione NullPointerException se il parametro è null.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che provando a rimuovere un oggetto non Entry, venga restituita una NullPointerException.
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
   * Il metodo myAdapter.MapAdapter.EntrySet.remove() restituisce NullPointerException.
   */
	@Test(expected = NullPointerException.class)
	public void removeNullTest() {
		entrySet.remove(null);
	}
	
	/**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.KeySet.removeAll(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo removeAll dell'EntrySet rimuova tutte le entry specificate dalla mappa e dall'EntrySet.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo rimuova da entrySet e corrispondente mappa tutte le entry sepcificate come parametro.
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
   * Il metodo myAdapter.MapAdapter.KeySet.removeAll(Object) deve rimuovere dalla mappa e corrispettivo entrySet tutte le entry sepcificate come parametro.
   */
	@Test
	public void removeAllTest() {
		Assert.assertFalse(entrySetF.isEmpty());
		entrySetF.removeAll(entrySetF2);
		Assert.assertTrue(entrySetF.isEmpty());
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.EntrySet.removeAllNullTest()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo removeAll dell'EntrySet sollevi un'eccezione NullPointerException se il parametro è null.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che provando a rimuovere un oggetto non Entry, venga restituita una NullPointerException.
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
   * Il metodo myAdapter.MapAdapter.EntrySet.removeAllNullTest() restituisce NullPointerException.
   */
	@Test(expected = NullPointerException.class)
	public void removeAllNullTest() {
		entrySet.removeAll(null);
	}
	
   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.KeySet.retainAll(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo retainAll dell'EntrySet mantenga solo le entry specificate e le rimuova dalla mappa e dall'EntrySet.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare se tutte le entry dell'entrySet sono contenute nell'entrySet specificato come parametro.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetti mapAdapterF di tipo MapAdapter e corrispettiva entrySetF inizializzati con 1 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetti mapAdapterF di tipo MapAdapter e corrispettiva entrySetF contenenti 8 entry.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.KeySet.retainAll(Object) deve restituire true se tutte le entry dell'entrySet sono contenute nell'entrySet specificato come parametro.
   */
	@Test
	public void retainAllTest() {
		for(int i = 2; i < 7; i++) {
			mapAdapterF.put("k" + i, "e" + i);
		}
		entrySetF.retainAll(entrySetF2);
		Assert.assertTrue(entrySetF.contains(new Entry("k", "e")));
		for(int i = 2; i < 7; i++) {
			Assert.assertFalse(entrySetF.contains(new Entry("k" + i, "e" + i)));
		}
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.EntrySet.retainAllNullTest()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo retainAll dell'EntrySet mantenga solo le entry specificate e le rimuova dalla mappa e dall'EntrySet.
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
   * Il metodo myAdapter.MapAdapter.EntrySet.retainAllNullTest() restituisce NullPointerException.
   */
	@Test(expected = NullPointerException.class)
	public void retainAllNullTest() {
		entrySet.retainAll(null);
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.KeySet.toArray()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo toArray dell'EntrySet restituisca correttamente un array contenente tutte le entry dell'EntrySet.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare se il metodo restituisce correttamente l'array corrispondente all'entrySet specificato.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetti mapAdapter di tipo MapAdapter e corrispettiva entrySet inizializzati con 0 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetti mapAdapter di tipo MapAdapter e corrispettiva entrySet contenenti 5 entry.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.KeySet.toArray() deve restituire l'array corrispondente all'entrySet specificato.
   */
	@Test
	public void toArrayTest(){
		for(int i = 0; i < 5; i++) {
			mapAdapter.put("k" + i, "e" + i);
		}
		
		Object[] o = entrySet.toArray();
		int i;
		for(i = 0; i < o.length; i++) {
			Assert.assertTrue(entrySet.contains(o[i]));
		}
		Assert.assertEquals(i, entrySet.size());
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.EntrySet.toArrayParamTest()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo toArray dell'EntrySet restituisca un array specificato come parametro se ha la stessa dimensione dell'EntrySet, altrimenti restituisce un nuovo array.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo restituisca un array di entry partendo da un array passato come parametro.
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
   * Il metodo myAdapter.MapAdapter.EntrySet.toArrayParamTest() restituisce un array di entry partendo da un array passato come parametro.
   */
	@Test
	public void toArrayParamTest(){
		for(int i = 0; i < 5; i++) {
			mapAdapter.put("k" + i, "e" + i);
		}
		
		Object[] test = new Object[entrySet.size()];
		Assert.assertTrue(entrySet.toArray(test)==test);
		
		Object[] test2 = new Object[entrySet.size() - 1];
		Assert.assertFalse(entrySet.toArray(test2)==test2);
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.EntrySet.equals()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo equals dell'EntrySet restituisca true se l'EntrySet specificato è uguale all'EntrySet corrente.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo restituisca true se entrambi gli entrySet sono uguali.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto entrySetF e entrySetF2 di tipo HSet inizializzato su una mappa con 1 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * L'oggetto entrySetF e entrySetF2 rimangono invariati.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.EntrySet.equals() restituisce true se gli entrySet sono equivalenti.
   */
	@Test
	public void equalsTest(){
		Assert.assertTrue(entrySetF.equals(entrySetF2));
		
		entrySetF.clear();
		Assert.assertFalse(entrySetF.equals(entrySetF2));
		
		Assert.assertFalse(entrySetF.equals(null));
		Assert.assertFalse(entrySetF.equals("el"));
	}

   /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.KeySet.hashCode()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica che il metodo hashCode dell'EntrySet restituisca lo stesso valore per due EntrySet uguali e un valore diverso per EntrySet diversi.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare se il metodo restituisce true se l'entrySet corrisponde all'entrySet specificato come parametro.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetti mapAdapterF, entrySetF e mapAdapterF2, entrySetF2 contenenti 1 entry.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Oggetti mapAdapterF, entrySetF contenenti 1 entry e mapAdapterF2, entrySetF2 contenenti 2 entry.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.KeySet.hashCode() deve restituire l'hashCode corrispondente all'entrySet specificato.
   */
	@Test
	public void hashCodeTest(){
		Assert.assertEquals(entrySetF.hashCode(), entrySetF2.hashCode());
		mapAdapterF2.put("k", "el");
		Assert.assertNotEquals(entrySetF.hashCode(), entrySetF2.hashCode());
	}

}
