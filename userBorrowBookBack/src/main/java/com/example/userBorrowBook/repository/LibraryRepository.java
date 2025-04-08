package com.example.userBorrowBook.repository;

import com.example.userBorrowBook.model.Library;
import com.example.userBorrowBook.model.LibraryBasicInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, String> {

    // Basic projection query
    List<LibraryBasicInfo> findAllProjectedBy();

    // Custom query with projection
    @Query("SELECT l.id as id, l.name as name, l.city as city, l.email as email FROM Library l")
    List<LibraryBasicInfo> findAllLibrariesBasicInfo();

    // Find by city
    List<Library> findByCity(String city);

    // Find by city with projection
    List<LibraryBasicInfo> findByCity(String city, Class<LibraryBasicInfo> type);

    // Find by country
    List<Library> findByCountry(String country);

    // Find by capacity greater than
    List<Library> findByCapacityGreaterThan(int capacity);

    // Find by name containing (case insensitive)
    List<Library> findByNameContainingIgnoreCase(String name);

    // Find by email
    Library findByEmail(String email);

    // Paginated query
    Page<Library> findAll(Pageable pageable);

    // Custom search by multiple criteria
    @Query("SELECT l FROM Library l WHERE " +
            "(:name IS NULL OR l.name LIKE %:name%) AND " +
            "(:city IS NULL OR l.city = :city) AND " +
            "(:minCapacity IS NULL OR l.capacity >= :minCapacity)")
    List<Library> searchLibraries(String name, String city, Integer minCapacity);
}
