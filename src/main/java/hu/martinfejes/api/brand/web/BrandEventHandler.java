package hu.martinfejes.api.brand.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeLinkDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeLinkSave;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import hu.martinfejes.api.brand.Brand;
import hu.martinfejes.api.brand.BrandService;
import lombok.RequiredArgsConstructor;

/**
 * Event handler for the {@link User} entity.
 */
@Component
@RepositoryEventHandler
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BrandEventHandler {

  private final BrandService brandService;

  /**
   * Generate name_slug column on create/update.
   * @param user
   */
  @HandleBeforeCreate
  @HandleBeforeSave
  public void generateNameSlug(Brand brand) {
    brand = brandService.generateNameSlug(brand);
  }

  @HandleBeforeCreate
  @HandleBeforeSave
  @HandleBeforeDelete
  @HandleBeforeLinkSave
  @HandleBeforeLinkDelete
//   @PreAuthorize("hasRole('ADMIN')") TODO roles!
  public void onBeforeModify(final Brand entity){
    // noop
  }
}