package hu.martinfejes.api.brand;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import hu.martinfejes.api.brand.web.BrandProjection;

/**
 *  Repository class for {@link Brand}, using excerpt {@link BrandProjection}.
 */
@RepositoryRestResource(excerptProjection = BrandProjection.class)
public interface BrandRepository extends PagingAndSortingRepository<Brand, Long> {

   Brand findByNameSlug(String slug);
}
