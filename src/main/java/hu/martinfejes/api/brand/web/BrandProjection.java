package hu.martinfejes.api.brand.web;

import org.springframework.data.rest.core.config.Projection;

import hu.martinfejes.api.brand.Brand;

/**
 * Interface for the Projection of {@link User}.
 */
@Projection(name = "brandExcerpt", types = { Brand.class })
public interface BrandProjection {

    String getName();

    String getNameSlug();

}