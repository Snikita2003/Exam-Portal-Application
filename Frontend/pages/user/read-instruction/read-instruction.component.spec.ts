import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReadInstructionComponent } from './read-instruction.component';

describe('ReadInstructionComponent', () => {
  let component: ReadInstructionComponent;
  let fixture: ComponentFixture<ReadInstructionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReadInstructionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReadInstructionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
