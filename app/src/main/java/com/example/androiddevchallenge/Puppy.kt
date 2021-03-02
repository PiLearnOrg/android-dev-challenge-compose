package com.example.androiddevchallenge

data class Puppy(
    val id: Int,
    val name: String,
    val picture: Int
)

val puppies
    get() = arrayListOf(
        Puppy(0,"Beagle", R.drawable.beagle),
        Puppy(1, "Border Collie", R.drawable.border_collie),
        Puppy(2, "Cavalier King Charles Spaniel", R.drawable.cavalier_king_charles_spaniel),
        Puppy(3, "Duitse Herder", R.drawable.duitse_herder),
        Puppy(4, "Franse Bulldog", R.drawable.franse_bulldog)
    )
