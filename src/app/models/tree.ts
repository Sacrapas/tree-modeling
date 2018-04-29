import {Cell} from '@app/models/cell';

export interface Tree {
    id: number;
    content: Cell[];
    title?: string;
}
