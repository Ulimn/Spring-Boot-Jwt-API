package hu.martinfejes.api.brand;

import java.util.Arrays;

import com.github.slugify.Slugify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Class for initializing {@link Brand} entities.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BrandInitializer {

    private final @NonNull BrandRepository brandRepository;
    private final @NonNull BrandService brandService;

    @EventListener
    public void init(ApplicationReadyEvent event) {
        if (brandRepository.count() != 0) {
            return;
        }

        Brand brand1 = new Brand();
        brand1.setName("Demo Brand 1");
        brand1 = brandService.generateNameSlug(brand1);

        Brand brand2 = new Brand();
        brand2.setName("Dummy Brand 2");
        brand2 = brandService.generateNameSlug(brand2);

        Brand brand3 = new Brand();
        brand3.setName("Exmaple Brand 3");
        brand3 = brandService.generateNameSlug(brand3);

        brandRepository.saveAll(Arrays.asList(brand1, brand2, brand3));
    }
}