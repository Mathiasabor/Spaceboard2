package com.amarerichard.services

import com.amarerichard.database.repository.ProjectRepository
import com.amarerichard.model.Project
import com.amarerichard.model.callModel.cProject
import org.bson.types.ObjectId

class Projectservice() {
   private val projectrepository = ProjectRepository()
    suspend fun addProject(cproject : cProject) : String
    {
        val project = Project(
            Id = ObjectId().toString(),
            Name = cproject.name,
            Author = cproject.author
        )
       return projectrepository.addproject(project)
    }

    suspend fun deleteProject(projectid : String) : Long
    {
       return projectrepository.deleteproject(projectid)
    }

    suspend fun updateProject(projecttoupdate : Project) : Long
    {
        return  projectrepository.updateproject(projecttoupdate)
    }

   suspend fun getAllProject() : List<Project>
    {
        return projectrepository.getAllProject()
    }
}