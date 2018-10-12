package hu.martinfejes.api.brand;

import com.github.slugify.Slugify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * Implementation for the {@link BrandService} interface.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BrandServiceImpl implements BrandService {

    private final Slugify slugify;

    @Override
    public Brand generateNameSlug(Brand brand) {
        brand.setNameSlug(slugify.slugify(brand.getName()));
        return brand;
    }
}