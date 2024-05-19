package com.suunny.EcomProductServiceSandeep.Repository;

import com.suunny.EcomProductServiceSandeep.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category , UUID> {
}
