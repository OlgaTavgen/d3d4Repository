package com.d3d4project.reactor;

import java.time.Duration;
import java.util.List;

import com.google.common.collect.Lists;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public final class ReactorUtility 
{
	public static Flux<String> getStringFlux(final String...elements)
	{
		return Flux.just(elements);
	}
	
	public static Mono<String> getStringMono(final String element)
	{
		return Mono.just(element);
	}
	
	public static Flux<Integer> getIntegerFlux(final Integer...elements)
	{
		return Flux.just(elements);
	}
	
	public static Mono<Integer> getIntegerMono(final Integer element)
	{
		return Mono.just(element);
	}
	
	public static List<String> collectStringFluxElementsToList(final String...elements)
	{
		final List<String> elementsList = Lists.newArrayList();
		
		getStringFlux(elements)
		.log()
		.subscribe(elementsList::add);
		
		return elementsList;
	}
	
	public static List<Integer> collectIntegerFluxElementsToList(final Integer...elements)
	{
		final List<Integer> elementsList = Lists.newArrayList();
		
		getIntegerFlux(elements)
		.log()
		.subscribe(elementsList::add);
		
		return elementsList;
	}
	
	public static void deleteStringFluxElementsFromList(
			final List<String> sourceList, final String...elements)
	{
		getStringFlux(elements)
		.log()
		.subscribe(sourceList::remove);
	}
	
	public static void deleteIntegerFluxElementsFromList(
			final List<Integer> sourceList, final Integer...elements)
	{
		getIntegerFlux(elements)
		.log()
		.subscribe(sourceList::remove);
	}
	
	public static List<Integer> multiplyStringFluxElements(
			final int multiplier, final Integer...elements)
	{
		final List<Integer> elementsList = Lists.newArrayList();
		
		getIntegerFlux(elements)
		.log()
		.map(el -> el * multiplier)
		.subscribe(elementsList::add);
		
		return elementsList;
	}
	
	public static void logMilliSecondsForTime(final int time)
	{
		Flux.create(fluxSink -> {
		    while(true) {
		        fluxSink.next(System.currentTimeMillis());
		    }
		})
		  .sample(Duration.ofSeconds(time))
		  .publish();
	}
}
