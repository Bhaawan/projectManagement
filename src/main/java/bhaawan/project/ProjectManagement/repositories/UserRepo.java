    package bhaawan.project.ProjectManagement.repositories;

    import bhaawan.project.ProjectManagement.models.UserModel;
    import org.springframework.data.mongodb.repository.MongoRepository;
    import org.springframework.stereotype.Repository;

    @Repository
    public interface UserRepo extends MongoRepository<UserModel, String> {
    }
