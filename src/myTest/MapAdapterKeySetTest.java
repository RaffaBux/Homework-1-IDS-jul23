package myTest;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import myAdapter.MapAdapter;

/**
 * <b>TEST SUITE MAP ADAPTER KEY SET TEST</b>
 * <br>
 * <br>
 * <b>Summary</b>
 * <br>
 * In questa classe di test andiamo a testare tutti i metodi presenti in MapAdapter.KeySet e MapAdapter.KeySetIterator con un test dedicato ad ogni singolo metodo.
 * <br>
 * L'obiettivo risulta quello di assicurarsi che all'inserimento di vari entry nel MapAdapter, la collezione di key corrispondente alla mappa sia corretta.
 * <br>
 * I test sono stati creati con la tecnologia Test Driven Development pertanto sono stati ideati prima del corrispettivo metodo di MapAdapter.EntrySet.
 * <br>
 * <br>
 *
 * <b>Test Suite Design</b>
 * <br>
 * Nella classe di testing abbiamo un test per ogni metodo implementato in MapAdapter.KeySet e MapAdapter.KeySetIterator.
 * Dei tre MapAdapter inizializzati, mapAdapter1 e mapAdapter2 contengono entry con stessi valori e key mentre mapAdapter3 contiene dei key diverse dalle altre due mappe.
 * Sono usate stringhe e valori semplici come chiavi e valori delle entry.
 * <br>
 *
 * <b>Pre-Conditions</b>
 * <br>
 * Nel @Before vengono inizializzate le tre mappe, e vengono inserite le entry di test.
 * <br>
 *
 * <b>Post-Conditions</b>
 * <br>
 * Dopo ogni test mapAdapter tornano a contenere le entry iniziali.
 * <br>
 *
 * <b>Test-cases</b>
 * <br>
 * Sono testati tutti i metodi di MapAdapter.KeySet e MapAdapter.KeySetIterator.
 * <br>
 *
 * <b>Test Suite Execution Records</b>
 * <br>
 * Tutti i 5 test vengono effettuati correttamente.
 * <br>
 *
 * <b>Execution Variables</b>
 * <br>
 * Viene utilzzate tre variabili MapAdapter private.
 * <br>
 *
 * @author Bussolotto Raffaele - n° mat.: 1224718
 * <br>
 */
public class MapAdapterKeySetTest {
  
  private MapAdapter mapAdapter1;
  private MapAdapter mapAdapter2;
  private MapAdapter mapAdapter3;

  @Before
  public void init() {
    mapAdapter1 = new MapAdapter();
    mapAdapter1.put("A", 1);
    mapAdapter1.put("B", 2);
    mapAdapter1.put("C", 3);

    mapAdapter2 = new MapAdapter();
    mapAdapter2.put("A", 1);
    mapAdapter2.put("B", 2);
    mapAdapter2.put("C", 3);

    mapAdapter3 = new MapAdapter();
    mapAdapter3.put("D", 1);
    mapAdapter3.put("E", 2);
    mapAdapter3.put("F", 3);
  }

  /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.KeySet.contains(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica se il metodo "contains(Object)" dell'insieme di chiavi ottenuto da "mapAdapter1" restituisce correttamente true quando una chiave esiste nella mappa e false altrimenti. 
   * Inoltre, verifica se l'aggiunta di una nuova entry alla mappa influisce sulla corretta restituzione di true.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo ritorni true quando cerco una chiave presente nella mappa e false altrimenti.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapter1 di tipo MapAdapter inizializzato con 3 elementi
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * La mappa contiene le 3 entry con cui viene inizializzata, e un nuovo elemento "D"-4.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.KeySet.contains(Object) deve ritornare true solo quando la chiave passata si trova nella mappa.
   */
  @Test
  public void containsTest() {
    Assert.assertTrue(mapAdapter1.keySet().contains("A"));
    Assert.assertFalse(mapAdapter1.keySet().contains("D"));
    mapAdapter1.put("D", 4);
    Assert.assertTrue(mapAdapter1.keySet().contains("D"));
  }

  /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.KeySet.remove(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica se il metodo "remove(Object)" dell'insieme di chiavi ottenuto da "mapAdapter1" rimuove correttamente l'entry corrispondente alla chiave fornita come argomento dalla mappa. 
   * Verifica anche se l'insieme di chiavi riflette correttamente le modifiche apportate alla mappa.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo rimuova dalla mappa una entry fornita la sua key come argomento.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapter1 di tipo MapAdapter inizializzato con 3 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * La mappa contiene le 2 entry poiché la entry "B"-2 è stata rimossa.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.KeySet.remove(Object) deve rimuovere dalla mappa solo la entry con key fornita come argomento.
   */
  @Test
  public void removeTest() {
    Assert.assertTrue(mapAdapter1.keySet().contains("B"));
    mapAdapter1.remove("B");
    Assert.assertFalse(mapAdapter1.keySet().contains("B"));
    Assert.assertEquals(2, mapAdapter1.keySet().size());
  }

  /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.KeySet.toArray()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica se il metodo "toArray()" dell'insieme di chiavi ottenuto da "mapAdapter1" restituisce un array contenente tutte le chiavi delle entry presenti nella mappa. 
   * Inoltre, verifica se la lunghezza dell'array restituito corrisponde al numero di entry nella mappa.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo ritorni un array contentente le key delle entry nella mappa.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapter1 di tipo MapAdapter inizializzato con 3 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * La mappa contiene le 3 entry con cui viene inizializzata.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.KeySet.toArray() deve ritornare un array contenente le key di tutte le entry della mappa dunque la lunghezza di questo
   * array dovrà corrispondere alle dimensioni della mappa.
   */
  @Test
  public void toArrayTest() {
    Object[] array = mapAdapter1.keySet().toArray();
    Assert.assertEquals(3, array.length);
  }

  /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.KeySet.equals(Object)
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica se il metodo "equals(Object)" dell'insieme di chiavi ottenuto da "mapAdapter1" restituisce correttamente true 
   * quando viene confrontato con l'insieme di chiavi ottenuto da "mapAdapter2", e false quando viene confrontato con l'insieme di chiavi ottenuto da "mapAdapter3".
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo ritorni true quando confonto due mappe contenenti entry equivalenti.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetti mapAdapter1, mapAdapter2, mapAdapter3 di tipo MapAdapter inizializzate con 3 elementi.
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * Le mappe contengono le 3 entry con cui vengono inizializzate.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.KeySet.equals(Object) deve ritornare true solo quando le due mappe hanno le stesse entry.
   */
  @Test
  public void equalsTest() {
    Assert.assertTrue(mapAdapter1.keySet().equals(mapAdapter2.keySet()));
    Assert.assertFalse(mapAdapter1.keySet().equals(mapAdapter3.keySet()));
  }

  /**
   * <b>Test</b>
   * <br>
   * myAdapter.MapAdapter.KeySet.iterator()
   * <br>
   * <b>Summary / Test Description</b>
   * <br>
   * Verifica se il metodo "iterator()" dell'insieme di chiavi ottenuto da "mapAdapter1" restituisce un iteratore valido. 
   * Inoltre, verifica se l'iteratore restituisce correttamente la prima chiave nell'insieme di chiavi.
   * <br>
   * <b>Design</b>
   * <br>
   * Test per controllare che il metodo ritorni un iteratore del keyset della mappa.
   * <br>
   * <b>Pre-Condizioni</b>
   * <br>
   * Oggetto mapAdapter1 di tipo MapAdapter inizializzato con 3 elementi
   * <br>
   * <b>Post-Condizioni</b>
   * <br>
   * La mappa contiene le 3 mappature con cui viene inizializzata.
   * <br>
   * <b>Risultato atteso</b>
   * <br>
   * Il metodo myAdapter.MapAdapter.KeySet.iterator() deve ritornare un oggetto KeySetIterator valido e dunque non nullo.
   */
  @Test
  public void iteratorTest() {
		Assert.assertNotNull(mapAdapter1.keySet().iterator());
    Assert.assertEquals("A", mapAdapter1.keySet().iterator().next());
  }

}
