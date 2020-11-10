import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { ImageService } from '../image.service';

import { ImageDetailComponent } from './image-details.component';

describe('ImageDetailsComponent', () => {
  const paramId: any = 1;
  let component: ImageDetailComponent;
  let fixture: ComponentFixture<ImageDetailComponent>;
  let element: HTMLElement;
  
  var fakeActivatedRoute = {
    snapshot: { params: { 'id': paramId } }
  } as unknown as ActivatedRoute;

  it('ImageDetailComponent created', () => {
    setFakeActivatedRouteValues(1);
    
    TestBed.configureTestingModule({
      declarations: [ ImageDetailComponent ],
      providers: [ImageDetailComponent, ImageService, {provide: ActivatedRoute, useValue: fakeActivatedRoute}]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ImageDetailComponent);
    component = fixture.componentInstance;
    element = fixture.nativeElement.querySelector('.img-container');
    fixture.detectChanges();

    expect(component).toBeTruthy();
  });

  it("A container hold an image when click on it", () => {
    setFakeActivatedRouteValues(1);
    
    TestBed.configureTestingModule({
      declarations: [ ImageDetailComponent ],
      providers: [ImageDetailComponent, ImageService, {provide: ActivatedRoute, useValue: fakeActivatedRoute}]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ImageDetailComponent);
    component = fixture.componentInstance;
    element = fixture.nativeElement.querySelector('.img-container');
    fixture.detectChanges();
    
    expect(element.style.getPropertyValue("background-image")).toBe(`url("assets/images/perro1.jpg")`);
  });

  it("The image doesn't exist for a bad url", () => {
    setFakeActivatedRouteValues(10);
    
    TestBed.configureTestingModule({
      declarations: [ ImageDetailComponent ],
      providers: [ImageDetailComponent, ImageService, {provide: ActivatedRoute, useValue: fakeActivatedRoute}]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ImageDetailComponent);
    component = fixture.componentInstance;
    element = fixture.nativeElement.querySelector('.img-container');
    fixture.detectChanges();

    expect(element.style.getPropertyValue("background-image")).toBe(`url("null")`);
  });

  var setFakeActivatedRouteValues = (value) => {
    fakeActivatedRoute = {
      snapshot: { params: { 'id': value } }
    } as unknown as ActivatedRoute;
  }
});

describe('ImageDetailsComponent (class only)', () => {
  const paramId: any = 1;
  let component: ImageDetailComponent;
  let service: ImageService;

  var fakeActivatedRoute = {
    snapshot: { params: { 'id': paramId } }
  } as unknown as ActivatedRoute;

  it('Obtain all Images', () => {
    setFakeActivatedRouteValues(1);

    TestBed.configureTestingModule({
      imports: [ RouterTestingModule ],
      providers: [ImageDetailComponent, ImageService, {provide: ActivatedRoute, useValue: fakeActivatedRoute}]
    });

    component = TestBed.inject(ImageDetailComponent);
    service = TestBed.inject(ImageService);
    
    component.ngOnInit();
    let expectedImages = service.getImage(paramId);
    expect(component.image).toEqual(expectedImages);
  });

  it('Undefined for a none existing ID', () => {
    setFakeActivatedRouteValues(10);

    TestBed.configureTestingModule({
      imports: [ RouterTestingModule ],
      providers: [ImageDetailComponent, ImageService, {provide: ActivatedRoute, useValue: fakeActivatedRoute}]
    });

    component = TestBed.inject(ImageDetailComponent);
    service = TestBed.inject(ImageService);

    component.ngOnInit();
    expect(component.image).toBe(undefined);
  });

  it('Undefined when filtering by undefined id', () => {
    setFakeActivatedRouteValues(undefined);

    TestBed.configureTestingModule({
      imports: [ RouterTestingModule ],
      providers: [ImageDetailComponent, ImageService, {provide: ActivatedRoute, useValue: fakeActivatedRoute}]
    });

    component = TestBed.inject(ImageDetailComponent);
    service = TestBed.inject(ImageService);

    component.ngOnInit();
    expect(component.image).toBe(undefined);
  });

  var setFakeActivatedRouteValues = function(value) {
    fakeActivatedRoute = {
      snapshot: { params: { 'id': value } }
    } as unknown as ActivatedRoute;
  }
});