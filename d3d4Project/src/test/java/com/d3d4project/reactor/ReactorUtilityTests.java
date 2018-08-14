package com.d3d4project.reactor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.FinalizablePhantomReference;
import com.google.common.collect.Lists;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SuppressWarnings("nls")
public final class ReactorUtilityTests 
{
	@Test
	public void testGetStringMono()
	{
		final Mono<String> stringMono = ReactorUtility.getStringMono("element0");
		
		assertThat(stringMono).isNotNull();
	}
	
	@Test
	public void testGetIntegerMono()
	{
		final Mono<Integer> integerMono = ReactorUtility.getIntegerMono(1);
		
		assertThat(integerMono).isNotNull();
	}
	
	@Test
	public void testGetStringFlux_threeStringElements()
	{
		final Flux<String> stringFlux = ReactorUtility.getStringFlux("element0", "element1", "element2");
		
		assertThat(stringFlux).isNotNull();
		
		final List<? extends Object> elements = collectFluxElementsToList(stringFlux);
		
		assertThat(elements.size()).isEqualTo(3);
		assertThat(elements.get(0)).isEqualTo("element0");
		assertThat(elements.get(1)).isEqualTo("element1");
		assertThat(elements.get(2)).isEqualTo("element2");
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetStringFlux_null()
	{
		final Flux<String> stringFlux = ReactorUtility.getStringFlux(null);
	}
	
	@Test
	public void testGetIntegerFlux_threeIntegerElements()
	{
		final Flux<Integer> integerFlux = ReactorUtility.getIntegerFlux(0, 1, 2);
		
		assertThat(integerFlux).isNotNull();
		
		final List<? extends Object> elements = collectFluxElementsToList(integerFlux);

		assertThat(elements.get(0)).isEqualTo(0);
		assertThat(elements.get(1)).isEqualTo(1);
		assertThat(elements.get(2)).isEqualTo(2);
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetIntegerFlux_null()
	{
		final Flux<Integer> stringFlux = ReactorUtility.getIntegerFlux(null);
	}	
	
	@Test(expected = NullPointerException.class)
	public void testGetStringMono_null()
	{
		final Mono<String> stringMono = ReactorUtility.getStringMono(null);	
	}
	
	@Test
	public void testCollectStringFluxElementsToList()
	{
		final List<String> elements = ReactorUtility.collectStringFluxElementsToList("element0", "element1", "element2");
		
		assertThat(elements).isNotNull();
		assertThat(elements.size()).isEqualTo(3);
		assertThat(elements.get(0)).isEqualTo("element0");
		assertThat(elements.get(1)).isEqualTo("element1");
		assertThat(elements.get(2)).isEqualTo("element2");
	}
	
	@Test
	public void testCollectIntegerFluxElementsToList()
	{
		final List<Integer> elements = ReactorUtility.collectIntegerFluxElementsToList(0, 1, 2);
		
		assertThat(elements).isNotNull();
		assertThat(elements.size()).isEqualTo(3);
		assertThat(elements.get(0)).isEqualTo(0);
		assertThat(elements.get(1)).isEqualTo(1);
		assertThat(elements.get(2)).isEqualTo(2);
	}
	
	@Test
	public void testDeleteStringFluxElementsFromList()
	{
		final List<String> elements = Lists.newArrayList("element0", "element1", "element2");
		ReactorUtility.deleteStringFluxElementsFromList(elements, "element1", "element2");

		assertThat(elements.size()).isEqualTo(1);
		assertThat(elements.get(0)).isEqualTo("element0");
	}
	
	@Test
	public void testDeleteStringFluxElementsFromList_missungElementToDelete()
	{
		final List<String> elements = Lists.newArrayList("element0", "element1", "element2");
		ReactorUtility.deleteStringFluxElementsFromList(elements, "element3");

		assertThat(elements.size()).isEqualTo(3);
	}
	
	@Test
	public void testDeleteIntegerFluxElementsFromList()
	{
		final List<Integer> elements = Lists.newArrayList(0, 1, 2);
		ReactorUtility.deleteIntegerFluxElementsFromList(elements, 1, 2);

		assertThat(elements.size()).isEqualTo(1);
		assertThat(elements.get(0)).isEqualTo(0);
	}
	
	@Test
	public void testDeleteIntegerFluxElementsFromList_missingElementToDelete()
	{
		final List<Integer> elements = Lists.newArrayList(0, 1, 2);
		ReactorUtility.deleteIntegerFluxElementsFromList(elements, 3);

		assertThat(elements.size()).isEqualTo(3);
	}
	
	@Test
	public void testMultiplyStringFluxElements()
	{
		final List<Integer> elements = ReactorUtility.multiplyStringFluxElements(5, 0, 1, 2);
		
		assertThat(elements).isNotNull();
		assertThat(elements.size()).isEqualTo(3);
		assertThat(elements.get(0)).isEqualTo(0);
		assertThat(elements.get(1)).isEqualTo(5);
		assertThat(elements.get(2)).isEqualTo(10);
	}
	
	private List<? extends Object> collectFluxElementsToList(final Flux<? extends Object> flux)
	{
		final List<Object> destList = Lists.newArrayList();
		final Iterator<? extends Object> iterator = flux.toIterable().iterator();
	
		while (iterator.hasNext())
		{
			destList.add(iterator.next());
		}
		
		return destList;
	}
}
