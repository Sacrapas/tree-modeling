export interface Cell {
  name:      string;
  children?: Cell[];
  id?:       number;
  links?:    number[];
}
