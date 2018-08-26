package com.epam.podcast.services;

import com.epam.podcast.beans.Podcast;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/podcasts")
@Api(value="podcasts", description="Podcasts services")
public class PodcastController
{
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> add(@PathVariable Long id, @RequestBody Podcast input)
    {
        Podcast result = new Podcast(id, "new Podcast", "www.example.com", "", "example text");
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> add(@RequestBody Podcast input)
    {
        Podcast result = new Podcast(1l, "new Podcast1", "www.example.com", "", "example text");
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "View the podcast", response = Podcast.class)
    @RequestMapping(method = RequestMethod.GET)
    public Podcast show(@PathVariable Long id)
    {
        return new Podcast(id, "new Podcast", "www.example.com", "", "example text");
    }
}
