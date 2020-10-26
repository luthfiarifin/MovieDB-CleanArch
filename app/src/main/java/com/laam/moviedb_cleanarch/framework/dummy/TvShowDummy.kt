package com.laam.moviedb_cleanarch.framework.dummy

import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.framework.model.TvShowEntity

object TvShowDummy {

    fun generateDummyTvShow(): List<TvShowEntity> {
        val tvShows = arrayListOf<TvShowEntity>()

        tvShows.add(
            TvShowEntity(
                1L,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                6.5F,
                R.drawable.poster_arrow,
                "Crime, Drama, Mystery, Action & Adventure"
            )
        )

        tvShows.add(
            TvShowEntity(
                2L,
                "Dragon Ball",
                "With Majin Boo defeated half-a-year prior, peace returns to Earth, where Son Goku (now a radish farmer) and his friends now live peaceful lives. However, a new threat appears in the form of Beerus, the God of Destruction. Considered the most terrifying being in the entire universe, Beerus is eager to fight the legendary warrior seen in a prophecy foretold decades ago known as the Super Saiyan God. The series retells the events from the two Dragon Ball Z films, Battle of Gods and Resurrection 'F' before proceeding to an original story about the exploration of alternate universes.",
                8.1F,
                R.drawable.poster_dragon_ball,
                "Animation, Mystery, Action, Comedy"
            )
        )

        tvShows.add(
            TvShowEntity(
                3L,
                "Fairy Tail",
                "Natsu Dragneel and his friends travel to the island Kingdom of Stella, where they will reveal dark secrets, fight the new enemies and once again save the world from destruction.",
                6.5F,
                R.drawable.poster_fairytail,
                "Action, Adventure, Fantasy"
            )
        )

        tvShows.add(
            TvShowEntity(
                4L,
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                6.8F,
                R.drawable.poster_family_guy,
                "Drama, Music"
            )
        )

        tvShows.add(
            TvShowEntity(
                5L,
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                7.5F,
                R.drawable.poster_doom_patrol,
                "Sci-Fi, Fantasy, Action, Adventurer"
            )
        )

        tvShows.add(
            TvShowEntity(
                6L,
                "Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                7.5F,
                R.drawable.poster_flash,
                "Drama, Sci-Fi"
            )
        )

        tvShows.add(
            TvShowEntity(
                7L,
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                7.4F,
                R.drawable.poster_gotham,
                "Fantasy, Drama"
            )
        )

        tvShows.add(
            TvShowEntity(
                8L,
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                8.0F,
                R.drawable.poster_grey_anatomy,
                "Drama"
            )
        )

        tvShows.add(
            TvShowEntity(
                9L,
                "Hanna",
                " This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                7.4F,
                R.drawable.poster_hanna,
                "Action, Adventure, Drama"
            )
        )

        tvShows.add(
            TvShowEntity(
                10L,
                "Marvel's Iron Fist",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                6.4F,
                R.drawable.poster_iron_fist,
                "Action, Adventure, Drama, Sci-Fi"
            )
        )

        tvShows.add(
            TvShowEntity(
                11L,
                "Naruto Shippūden",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                8.7F,
                R.drawable.poster_naruto_shipudden,
                "Animation, Comedy,Drama"
            )
        )

        tvShows.add(
            TvShowEntity(
                12L,
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                8.1F,
                R.drawable.poster_supernatural,
                "Drama, Mystery, Sci-Fi & Fantasy"
            )
        )

        return tvShows
    }
}