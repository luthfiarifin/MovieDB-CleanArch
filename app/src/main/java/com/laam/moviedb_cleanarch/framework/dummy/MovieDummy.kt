package com.laam.moviedb_cleanarch.framework.dummy

import com.laam.core.model.Movie
import com.laam.moviedb_cleanarch.R

object MovieDummy {

    fun generateDummyMovie(): List<Movie> {
        val movies = arrayListOf<Movie>()

        movies.add(
            Movie(
                1L,
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                7.5F,
                null,
                "Drama, Romance, Music",
                "10/05/2018"
            )
        )

        movies.add(
            Movie(
                2L,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                7.1F,
                null,
                "Action, Science Fiction, Adventure",
                "02/14/2019"
            )
        )

        movies.add(
            Movie(
                3L,
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                6.9F,
                null,
                "Action, Adventure, Fantasy",
                "12/21/2018"
            )
        )

        movies.add(
            Movie(
                4L,
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                8.0F,
                null,
                "Drama, Music",
                "11/02/2018"
            )
        )

        movies.add(
            Movie(
                5L,
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                5.6F,
                null,
                "Action, Crime, Thriller",
                "02/08/2019"
            )
        )

        movies.add(
            Movie(
                6L,
                "Creed",
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                7.4F,
                null,
                "Drama",
                "11/25/2015"
            )
        )

        movies.add(
            Movie(
                7L,
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                6.9F,
                null,
                "Adventure, Fantasy, Drama",
                "11/16/2018"
            )
        )

        movies.add(
            Movie(
                8L,
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                6.6F,
                null,
                "Thriller, Drama, Science Fiction",
                "01/18/2019"
            )
        )

        movies.add(
            Movie(
                9L,
                "Avengers: Infinity War",
                " the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                8.3F,
                null,
                "Action, Adventure, Action, Science Fiction",
                "02/08/2019"
            )
        )

        movies.add(
            Movie(
                10L,
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                7.8F,
                null,
                "Animation, Family, Adventure",
                "02/22/2019"
            )
        )

        movies.add(
            Movie(
                11L,
                "Mary Queen of Scots",
                "n 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                6.6F,
                null,
                "Drama, History",
                "12/21/2018"
            )
        )

        movies.add(
            Movie(
                12L,
                "Master Z: Ip Man Legacy",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                5.6F,
                null,
                "Action",
                "12/26/2018"
            )
        )

        return movies
    }
}