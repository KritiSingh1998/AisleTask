package com.example.aisletask.model

data class NotesDetails(val invites: Invites, val likes: Likes)
data class Invites(val profiles: List<Profiles>)
data class Profiles(val general_information: GeneralInformation, val photos: List<Photos>)
data class GeneralInformation(val first_name: String, val age: Int)
data class Photos(val photo: String)
data class Likes(val profiles: List<LikeProfiles>)
data class LikeProfiles(val first_name: String, val avatar: String)