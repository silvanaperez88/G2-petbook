import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FilterimagesPipe } from '../filterimages.pipe';
import { ImageService } from '../image.service';
import { GalleryComponent } from './image-gallery.component';

describe('ImageGalleryComponent', () => {
  let fixture: ComponentFixture<GalleryComponent>;
  var component: GalleryComponent;
  let element: HTMLElement;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [GalleryComponent, FilterimagesPipe],
      providers: [ImageService, FilterimagesPipe]
    }).compileComponents();
  })
  );

  beforeEach(() => {
    fixture = TestBed.createComponent(GalleryComponent);
    component = fixture.componentInstance;
  });

  it('GalleryComponent created', () => {
    expect(component).toBeTruthy();
  });

  it('Show images filtered by all', () => {
    element = fixture.nativeElement.querySelector('.row ul');
    component.filterBy = "all";
    fixture.detectChanges();
    expect(element.childElementCount).toBe(5);
  });

  it('Show images filtered by perro', () => {
    element = fixture.nativeElement.querySelector('.row ul');
    component.filterBy = "perro";
    fixture.detectChanges();
    expect(element.childElementCount).toBe(3);
  });

  it('No images when filter by an unknown value', () => {
    element = fixture.nativeElement.querySelector('.row ul');
    component.filterBy = "somethingThatDoesnotExist";
    fixture.detectChanges();
    expect(element.childElementCount).toBe(0);
  });
});

describe('ImageGalleryComponent (class only)', () => {
  let component: GalleryComponent;
  let service: ImageService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GalleryComponent, ImageService]
    });

    component = TestBed.inject(GalleryComponent);
    service = TestBed.inject(ImageService);
  });

  it('Obtain all images', () => {
    component.ngOnChanges();
    let expectedImages = service.getImages();
    expect(component.allImages).toEqual(expectedImages);
  });
});