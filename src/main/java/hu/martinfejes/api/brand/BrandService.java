package hu.martinfejes.api.brand;

import org.springframework.stereotype.Service;

/**
 * Service for the {@link Brand} entity.
 */
@Service
public interface BrandService {

    Brand generateNameSlug(Brand brand);
}