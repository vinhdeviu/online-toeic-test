export const deleteObjectsFromArray = function(arrayOfObjects, listToDelete) {
    for (var i = 0; i < arrayOfObjects.length; i++) {
        var obj = arrayOfObjects[i];
    
        if (listToDelete.indexOf(obj.id) !== -1) {
            arrayOfObjects.splice(i, 1);
        }
    }
}

export const deleteObjectByIdFromArray = function(arrayOfObjects, objectIdToDelete) {
    for (var i = 0; i < arrayOfObjects.length; i++) {
        var obj = arrayOfObjects[i];
        if (objectIdToDelete == obj.id) {
            arrayOfObjects.splice(i, 1);
            return;
        }
    }
}