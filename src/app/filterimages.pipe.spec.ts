import { FilterimagesPipe } from './filterimages.pipe';
import { ImageService } from './image.service';

describe('FilterimagesPipe', () => {
  var service: ImageService;
  var pipe: FilterimagesPipe;

  var images: any;

  beforeAll(() => {
    service = new ImageService();
    pipe = new FilterimagesPipe();

    images = service.getImages();
  });

  it('FilterimagesPipe instance created', () => {
    expect(pipe).toBeTruthy();
  });

  it('All images are obtained', () => {
    expect(images).toEqual(pipe.transform(images, "all"));
  });

  it('All cat images are obtained', () => {
    let imagesFilterByGato = images.filter(x => x.brand == "gato");

    expect(imagesFilterByGato).toEqual(pipe.transform(images, "gato"));
  });

  it('All dog images are obtained', () => {
    let imagesFilterByPerro = images.filter(x => x.brand == "perro");

    expect(imagesFilterByPerro).toEqual(pipe.transform(images, "perro"));
  });

  it('Undefined for an item not defined', () => {
    expect(undefined).toBe(pipe.transform(undefined, "all"));
  });

  it('Empty response for an undefined laptop field', () => {
    expect([]).toEqual(pipe.transform(images, undefined));
  });

  it('Empty response for an unknown value in the laptop field', () => {
    expect([]).toEqual(pipe.transform(images, "someUnknownValue"));
  });
});
